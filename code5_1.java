import org.junit.Test;

public class code5_1 {
    public void insert(int N, int M, int i, int j) {
        int mask = ~ (((1 << j) - 1) - ((1 << i) - 1));
        int result = (N & mask) | (M << i);
        System.out.println(Integer.toBinaryString(result));
    }

    @Test
    public void test() {
        int N = 0b10000000000;
        int M = 0b10011;
        int i = 2;
        int j = 6;
        insert(N, M, i, j);
    }
}