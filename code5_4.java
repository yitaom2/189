import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class code5_4 {
    public int getNext(int n) {
        ArrayList record = new ArrayList(Arrays.asList(Integer.toBinaryString(n).split("")));
        int to_flip = 0;
        boolean start = false;
        for (int index = record.size() - 1; index >= 0; index--) {
            if (record.get(index).equals("0") && start == true) {
                n &= ~((1 << (record.size() - 1 - index)) - 1);
                n |= (1 << (record.size() - 1 - index));
                n |= ((1 << (to_flip)) - 1);
                break;
            } else if (record.get(index).equals("1")) {
                start = true;
                to_flip++;
                n = n & (~(1 << (record.size() - 1 - index)));
            }
        }
        if (start == false) return -1;
        System.out.println(Integer.toBinaryString(n));
        return n;
    }

    @Test
    public void test() {
        int n = 0b11011011111100;
        getNext(n);
    }
}