public class code1_1 {
    public static void main(String[] args) {
        String to_check = args[0];

        // solution 1
        /*char[] toCheck = to_check.toCharArray();
        quicksort(toCheck, 0, to_check.length() - 1);
        System.out.println(toCheck);
        for (int i = 0; i < toCheck.length - 1; i++) {
            if (toCheck[i] == toCheck[i+1]) {
                System.out.println(false);
                return;
            }
        }
        System.out.println(true);*/

        // solution given
        /*System.out.println(isunique(to_check));*/

        // solution given
        System.out.println(isunique_a_z(to_check));
    }

    public static void quicksort(char[] to_check, Integer start, Integer end) {
        if (start >= end) {
            return;
        }
        Character to_compare = to_check[start];
        int cur_left = start + 1;
        for (int i = start + 1; i <= end; i++) {
            if (to_compare > to_check[i]) {
                Character temp = to_check[cur_left];
                to_check[cur_left] = to_check[i];
                to_check[i] = temp;
                cur_left += 1;
            }
        }
        to_check[start] = to_check[cur_left - 1];
        to_check[cur_left - 1] = to_compare;
        quicksort(to_check, start, cur_left - 2);
        quicksort(to_check, cur_left, end);
        return;
    }

    public static boolean isunique(String to_check) {
        if (to_check.length() > 128) {
            return false;
        }
        boolean[] record = new boolean[128];
        for (int i = 0; i < to_check.length(); i++) {
            int key = Integer.valueOf(to_check.charAt(i));
            if (record[key]) {
                return false;
            }
            record[key] = true;
        }
        return true;
    }

    public static boolean isunique_a_z(String to_check) {
        if (to_check.length() > 26) {
            return false;
        }
        Integer record = 0;
        for (int i = 0; i < to_check.length(); i++) {
            Integer key = Integer.valueOf(to_check.charAt(i) - 'a');
            if ((record & (1 << key)) > 0) {
                return false;
            }
            record |= (1 << key);
        }
        return true;
    }
}