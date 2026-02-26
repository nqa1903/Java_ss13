import java.util.ArrayList;
import java.util.List;

public class B3 {

    public static <T> List<T> findCommonPatients(List<T> a, List<T> b) {
        List<T> result = new ArrayList<>();
        for (T item : a) {
            if (b.contains(item) && !result.contains(item)) {
                result.add(item);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> noi1 = new ArrayList<>();
        noi1.add(101);
        noi1.add(102);
        noi1.add(105);

        List<Integer> ngoai1 = new ArrayList<>();
        ngoai1.add(102);
        ngoai1.add(105);
        ngoai1.add(108);

        System.out.println("Test Case 1 Output: " + findCommonPatients(noi1, ngoai1));

        List<String> noi2 = new ArrayList<>();
        noi2.add("DN01");
        noi2.add("DN02");
        noi2.add("DN03");

        List<String> ngoai2 = new ArrayList<>();
        ngoai2.add("DN02");
        ngoai2.add("DN04");

        System.out.println("Test Case 2 Output: " + findCommonPatients(noi2, ngoai2));
    }
}