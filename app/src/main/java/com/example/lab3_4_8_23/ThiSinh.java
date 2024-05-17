package com.example.lab3_4_8_23;

public class ThiSinh {
    private String SBD;
    private String Hoten;
    private double toan;
    private double hoa;
    private double ly;

    public ThiSinh(String SBD, String hoten, double toan,  double ly,double hoa) {
        this.SBD = SBD;
        Hoten = hoten;
        this.toan = toan;
        this.hoa = hoa;
        this.ly = ly;
    }

    public double DTB(){
        return TD()/3;
    }
    public double TD(){
        return toan+ly+hoa;
    }

    public String getSBD() {
        return SBD;
    }

    public void setSBD(String SBD) {
        this.SBD = SBD;
    }

    public String getHoten() {
        return Hoten;
    }

    public void setHoten(String hoten) {
        Hoten = hoten;
    }

    public double getToan() {
        return toan;
    }

    public void setToan(double toan) {
        this.toan = toan;
    }

    public double getHoa() {
        return hoa;
    }

    public void setHoa(double hoa) {
        this.hoa = hoa;
    }

    public double getLy() {
        return ly;
    }

    public void setLy(double ly) {
        this.ly = ly;
    }
}
