public class code1_4 {
    public static void main(String[] args) {
        String to_compare = args[0].toLowerCase();
        pal(to_compare);
    }

    public static void pal(String to_compare) {
        int[] record = new int[128];
        for (int i = 0; i < to_compare.length(); i++) {
            if (to_compare.charAt(i) == ' ') {
                continue;
            }
            int key = to_compare.charAt(i);
            record[key]++;
        }
        int odd = 0;
        for (int i = 0; i < 128; i++) {
            if (record[i] % 2 == 1) {
                odd++;
                if (odd > 1) {
                    System.out.println(false);
                    return;
                }
            }
        }
        System.out.println(true);
    }
}