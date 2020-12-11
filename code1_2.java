import java.lang.reflect.Array;
import java.util.Arrays;

public class code1_2 {
    public static void main(String[] args) {
        String compare1 = args[0];
        String compare2 = args[1];

        // solution 1
        /*Integer[] l1 = buildHash(compare1);
        Integer[] l2 = buildHash(compare2);
        for (int i = 0; i < l1.length; i++) {
            if (l1[i] != l2[i]) {
                System.out.println(false);
                return;
            }
        }
        System.out.println(true);*/

        // solution given
        /*if (compare1.length() != compare2.length()) {
            System.out.println(false);
            return;
        }

        char[] l1 = compare1.toCharArray();
        char[] l2 = compare2.toCharArray();
        Arrays.sort(l1);
        Arrays.sort(l2);
        if (Arrays.toString(l1).equals(Arrays.toString(l2))) {
            System.out.println(true);
            return;
        }
        System.out.println(false);*/

        // solution given
        if (compare1.length() != compare2.length()) {
            System.out.println(false);
            return;
        }

        Integer[] res = new Integer[128];
        Arrays.fill(res, 0);
        for (int i = 0; i < compare1.length(); i++) {
            Integer key = Integer.valueOf(compare1.charAt(i));
            res[key]++;
        }

        for (int i = 0; i < compare2.length(); i++) {
            Integer key = Integer.valueOf(compare2.charAt(i));
            res[key]--;
            if (res[key] < 0) {
                System.out.println(false);
                return;
            }
        }
        System.out.println(true);
    }

    public static Integer[] buildHash(String compare) {
        Integer[] res = new Integer[128];
        Arrays.fill(res, 0);
        for (int i = 0; i < compare.length(); i++) {
            Integer key = Integer.valueOf(compare.charAt(i));
            res[key]++;
        }
        return res;
    }
}