import java.util.Arrays;

public class code1_3 {
    public static void main(String[] args) {
        String origin = args[0];
        Integer length = Integer.valueOf(args[1]);

        // solution 1
        // String res = replace(origin.toCharArray(), length);

        // solution given
        String res = replace_given(origin.toCharArray(), length);
        System.out.println(res);
    }

    public static String replace(char[] origin, Integer length) {
        Integer[] match = new Integer[length];
        int counter = 0;
        System.out.println(Arrays.toString(origin));
        for (int i = 0; i < length; i++) {
            if (origin[i] == ' ') {
                match[i] = -counter;
                counter += 3;
            } else {
                match[i] = counter;
                counter++;
            }
        }
        for (int i = length - 1; i >= 0; i--) {
            if (match[i] < 0) {
                int start = -match[i];
                origin[start] = '%';
                origin[start+1] = '2';
                origin[start+2] = '0';
            } else {
                origin[match[i]] = origin[i];
            }
        }
        return new String(origin);
    }

    public static String replace_given(char[] origin, Integer length) {
        int counter = 0;
        for (int i = 0; i < length; i++) {
            if (origin[i] == ' ') {
                counter++;
            }
        }
        int index = length - 1 + counter * 2;
        for (int i = length - 1; i >= 0; i--) {
            if (origin[i] == ' ') {
                origin[index - 2] = '%';
                origin[index - 1] = '2';
                origin[index] = '0';
                index -= 3;
            } else {
                origin[index] = origin[i];
                index--;
            }
        }
        return new String(origin);
    }
}