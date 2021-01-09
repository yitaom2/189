import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class code5_3 {
    public void longest1(int n) {
        ArrayList<Integer> record = new ArrayList<>();

        Integer searchFor = 0;
        int count = 0;
        for (int index = 0; index < Integer.BYTES * 8; index++) {
            if ((n & 1) != searchFor) {
                searchFor = (~searchFor) & 1;
                record.add(count);
                count = 0;
            }
            n = n >>> 1;
            count++;
        }
        record.add(count);

        int max_length = 0;
        for (int index = 0; index < record.size(); index += 2) {
            if (record.get(index) == 1) {
                int new_length = 1;
                if (index > 0) new_length += record.get(index - 1);
                if (index < record.size() - 1) new_length += record.get(index + 1);
                if (max_length < new_length) {
                    max_length = new_length;
                }
            } else if (record.get(index) == 0) {
                continue;
            } else {
                int new_length = 0;
                if (index > 0) new_length = Math.max(record.get(index - 1), new_length);
                if (index < record.size() - 1) new_length = Math.max(record.get(index + 1), new_length);
                new_length++;
                if (max_length < new_length) {
                    max_length = new_length;
                }
            }
        }
        System.out.println(max_length);
    }

    public void longest2(int n) {
        Integer searchFor = 0;
        int max_length = 0;
        int count = 0;
        int last1 = 0;
        int last0 = 0;
        for (int index = 0; index < Integer.BYTES * 8; index++) {
            if ((n & 1) != searchFor) {
                if (searchFor == 0) {
                    last0 = count;
                } else {
                    if (last0 == 1) {
                        max_length = Math.max(max_length, last1 + count + 1);
                    } else if (last0 > 1) {
                        int new_length = Math.max(last1, count);
                        max_length = Math.max(max_length, new_length + 1);
                    }
                    last1 = count;
                }
                searchFor = (~searchFor) & 1;
                count = 0;
            }
            n = n >>> 1;
            count++;
        }
        if (searchFor == 0) {
            max_length = Math.max(max_length, last1 + 1);
        } else {
            if (last0 == 1) {
                max_length = Math.max(max_length, last1 + count + 1);
            } else if (last0 > 1) {
                int new_length = Math.max(last1, count);
                max_length = Math.max(max_length, new_length + 1);
            }
        }
        System.out.println(max_length);
    }

    @Test
    public void test() {
        longest2(1775);
    }
}