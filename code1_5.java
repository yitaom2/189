public class code1_5 {
    public static void main(String[] args) {
        String compare1 = args[0];
        String compare2 = args[1];
        oneAway(compare1, compare2);
    }

    public static void oneAway(String compare1, String compare2) {
        String longer = "";
        String shorter = "";
        if (compare1.length() - compare2.length() == 1) {
            longer = compare1;
            shorter = compare2;
        } else if (compare2.length() - compare1.length() == 1) {
            longer = compare2;
            shorter = compare1;
        } else if (compare2.length() == compare1.length()) {
            longer = compare2;
            shorter = compare1;
        } else {
            System.out.println(false);
            return;
        }
        for (int i = 0; i < longer.length(); i++) {
            if (i == longer.length() - 1) {
                System.out.println(true);
                return;
            }
            if (longer.charAt(i) != shorter.charAt(i)) {
                if (longer.substring(i + 1).equals(shorter.substring(i)) 
                || longer.substring(i + 1).equals(shorter.substring(i + 1))) {
                    System.out.println(true);
                    return;
                } else {
                    System.out.println(false);
                    return;
                }
            }
        }
    }
}