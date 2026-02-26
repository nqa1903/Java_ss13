import java.util.ArrayList;
import java.util.Iterator;

public class B1 {
    public static void main(String[] args) {
        ArrayList<Double> nhietDo = new ArrayList<>();
        nhietDo.add(36.5);
        nhietDo.add(40.2);
        nhietDo.add(37.0);
        nhietDo.add(12.5);
        nhietDo.add(39.8);
        nhietDo.add(99.9);
        nhietDo.add(36.8);

        System.out.println("Danh sách ban đầu: " + nhietDo);

        Iterator<Double> it = nhietDo.iterator();
        while (it.hasNext()) {
            double t = it.next();
            if (t < 34.0 || t > 42.0) {
                it.remove();
            }
        }

        System.out.println("Danh sách sau khi lọc: " + nhietDo);

        double tong = 0;
        for (double t : nhietDo) tong += t;

        double tb = tong / nhietDo.size();
        System.out.printf("Nhiệt độ trung bình: %.2f", tb);
    }
}