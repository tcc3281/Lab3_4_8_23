package com.example.lab3_4_8_23;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private TSDataBase db;
    private FloatingActionButton btn;
    private EditText search;
    private Adapter adapter;
    private List<ThiSinh> thiSinhList;
    private int curSelected=-1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        initData();
    }
    private void initData(){
//        db.addThiSing(new ThiSinh("ts01","chien tran",10,10,10));
//        db.addThiSing(new ThiSinh("ts02","hoang nguyen",9,8.3,10));
//        db.addThiSing(new ThiSinh("ts03","vanh",9,8.3,7));
//        db.addThiSing(new ThiSinh("ts06","oanh",5,8.3,7));
//        db.addThiSing(new ThiSinh("ts04","anh",9.4,8.3,7));
        thiSinhList.clear();
        thiSinhList.addAll(db.getAllThiSing());
        adapter.notifyDataSetChanged();
    }

    private void init(){
        listView=findViewById(R.id.id_list);
        search=findViewById(R.id.id_search);
        btn=findViewById(R.id.id_btn);
        thiSinhList=new ArrayList<>();
        adapter=new Adapter(thiSinhList,this);
        listView.setAdapter(adapter);
        db=new TSDataBase(this,"ThiSinh",null,1);
        registerForContextMenu(listView);
        setBtn();
        setListView();
    }
    private void setListView(){
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                curSelected=position;
                return false;
            }
        });
    }
    private void setBtn(){
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater=new MenuInflater(this);
        menuInflater.inflate(R.menu.context_menu,menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()==R.id.xoa){
            thiSinhList.remove(curSelected);
            db.deleteThiSinh(thiSinhList.get(curSelected));
            adapter.notifyDataSetChanged();
        }

        return super.onContextItemSelected(item);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=new MenuInflater(this);
        inflater.inflate(R.menu.option_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.sort_menu){
            Collections.sort(thiSinhList, new Comparator<ThiSinh>() {
                @Override
                public int compare(ThiSinh o1, ThiSinh o2) {
                    return o1.getSBD().compareTo(o2.getSBD());
                }
            });
            adapter.notifyDataSetChanged();
        }
        return super.onOptionsItemSelected(item);
    }
}