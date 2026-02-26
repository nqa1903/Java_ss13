import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class B2 {
    public static List<String> locVaSapXep(List<String> ds) {
        ArrayList<String> ketQua = new ArrayList<>();
        for (String thuoc : ds) {
            if (!ketQua.contains(thuoc)) {
                ketQua.add(thuoc);
            }
        }
        Collections.sort(ketQua);
        return ketQua;
    }

    public static void main(String[] args) {
        List<String> input = new ArrayList<>();
        input.add("Paracetamol");
        input.add("Ibuprofen");
        input.add("Panadol");
        input.add("Paracetamol");
        input.add("Aspirin");
        input.add("Ibuprofen");

        System.out.println("Input: " + input);
        System.out.println("Output: " + locVaSapXep(input));
    }
}