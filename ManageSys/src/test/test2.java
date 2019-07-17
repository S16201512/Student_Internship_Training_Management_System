public class test2 {
    public static void main(String[] args) {
        String end_time="2019-01-16 00:00:00";
        String  end_time1=end_time.substring(0,10);
        String end_time2=end_time.substring(11,19);
        String end_time3=end_time1+"T"+end_time2;
        System.out.println(end_time1);
        System.out.println(end_time2);
        System.out.println(end_time1+"T"+end_time2);
    }
}
