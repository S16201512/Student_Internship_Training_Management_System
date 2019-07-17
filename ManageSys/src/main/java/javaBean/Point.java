package javaBean;

public class Point {
    private double j;
    private double w;
    private String spot;
    public Point(double j,double w,String spot){
        this.j=j;
        this.w=w;
        this.spot=spot;
    }

    public double getJ() {
        return j;
    }

    public void setJ(double j) {
        this.j = j;
    }

    public double getW() {
        return w;
    }

    public void setW(double w) {
        this.w = w;
    }

    public String getSpot() {
        return spot;
    }

    public void setSpot(String spot) {
        this.spot = spot;
    }
}
