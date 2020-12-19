public class code1_6 {
    public static void main(String[] args) {
        String origin = args[0];

        // solution 1
        // replace(origin);

        // solution given
        replace_sol(origin);
    }

    public static void replace(String origin) {
        int shorter_count = 0;
        for (int i = 0; i < origin.length(); i++) {
            int j = i + 1;
            while (j < origin.length() && origin.charAt(j) == origin.charAt(i)) {
                j++;
            }
            shorter_count += (j - i) - 1 - String.valueOf((j - i)).length();
            i = j - 1;
        }
        System.out.println(shorter_count);
        if (shorter_count <= 0) {
            System.out.println(origin);
            return;
        }
        String[] res = new String[origin.length() - shorter_count];
        int counter = 0;
        for (int i = 0; i < origin.length(); i++) {
            int j = i + 1;
            while (j < origin.length() && origin.charAt(j) == origin.charAt(i)) {
                j++;
            }
            res[counter] = String.valueOf(origin.charAt(i));
            res[counter + 1] = String.valueOf(j - i);
            counter += 2;
            i = j - 1;
        }
        System.out.println(String.join("", res));
    }

    public static void replace_sol(String origin) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < origin.length(); i++) {
            int j = i + 1;
            while (j < origin.length() && origin.charAt(j) == origin.charAt(i)) {
                j++;
            }
            res.append(String.valueOf(origin.charAt(i)) + String.valueOf(j - i));
            i = j - 1;
        }
        String compressed = res.toString();
        System.out.println(compressed.length() < origin.length() ? compressed : origin);
    }
}