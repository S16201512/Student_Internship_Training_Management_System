package util;

import javaBean.Point;

import java.util.ArrayList;

public class DistanceUtil {
    ArrayList<Point> pointList=new ArrayList<Point>();
    public static   int getDistance(String first,String second) {
        Point one=null;
        Point another=null;
        ArrayList<Point> pointArrayList=getPointList();
        for (Point e:pointArrayList){
            System.out.println("second："+first);
            if(e.getSpot().trim().equals(first)){
                one=e;
            }
            if(e.getSpot().trim().equals(second)){
                another=e;
            }

        }
        double x, y, out;
        double PI = Math.PI;
        double R = 6.371229 * 1e6;
        x = (another.getJ() - one.getJ()) * PI * R * Math.cos(((another.getW() + one.getW()) / 2) * PI / 180) / 180;
        y = (another.getW() - one.getW()) * PI * R / 180;
        out = Math.sqrt(x * x + y * y);
        return (int)(out / 1000);
    }
    public static  ArrayList<Point> getPointList(){
        ArrayList<Point> pointList=new ArrayList<>();
        Point sh = new Point(121.29, 31.14, "上海");
        pointList.add(sh);
        Point wh = new Point(114.21, 30.37, "武汉");
        pointList.add(wh);
        Point bj = new Point(116.28, 39.54, "北京");
        pointList.add(bj);
        Point tj = new Point(117.11, 39.09, "天津");
        pointList.add(tj);
        Point cq = new Point(106.32, 29.32, "重庆");
        pointList.add(cq);
        Point hhht = new Point(111.48, 40.49, "呼和浩特");
        pointList.add(hhht);
        Point sjz = new Point(114.28, 38.02, "石家庄");
        pointList.add(sjz);
        Point ty = new Point(112.34, 37.52, "太原");
        pointList.add(ty);
        Point jn = new Point(117, 36.38, "济南");
        pointList.add(jn);
        Point zz = new Point(113.42, 34.48, "郑州");
        pointList.add(zz);
        Point xa = new Point(108.54, 34.16, "西安");
        pointList.add(xa);
        Point lz = new Point(103.49, 36.03, "兰州");
        pointList.add(lz);
        Point yc = new Point(106.16, 38.20, "银川");
        pointList.add(yc);
        Point xn = new Point(101.45, 36.38, "西宁");
        pointList.add(xn);
        Point wlmq = new Point(87.36, 43.48, "乌鲁木齐");
        pointList.add(wlmq);
        Point hf = new Point(117.18, 31.51, "合肥");
        pointList.add(hf);
        Point nj = new Point(118.50, 32.02, "南京");
        pointList.add(nj);
        Point hz = new Point(120.09, 30.14, "杭州");
        pointList.add(hz);
        Point cs = new Point(113, 28.11, "长沙");
        pointList.add(cs);
        Point nc = new Point(115.52, 28.41, "南昌");
        pointList.add(nc);
        Point cd = new Point(104.05, 30.39, "成都");
        pointList.add(cd);
        Point gy = new Point(106.42, 26.35, "贵阳");
        pointList.add(gy);
        Point fz = new Point(119.18, 26.05, "福州");
        pointList.add(fz);
        Point gz = new Point(113.15, 23.08, "广州");
        pointList.add(gz);
        Point nn = new Point(108.20, 22.48, "南宁");
        pointList.add(nn);
        Point km = new Point(102.41, 25, "昆明");
        pointList.add(km);
        Point ls = new Point(91.10, 29.40, "拉萨");
        pointList.add(ls);
        return pointList;
    }

}
