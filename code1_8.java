import java.util.Arrays;

public class code1_8 {
    public static void main(String[] args) {
        Integer[][] check = {{1,1,1,1,1},{1,1,1,0,1},{1,1,1,1,1}};
        setZero(check);
    }

    public static void setZero(Integer[][] matrix) {
        Boolean[] row = new Boolean[matrix.length];
        if (row.length == 0) {
            return;
        }
        Boolean[] col = new Boolean[matrix[0].length];
        Arrays.fill(row, false);
        Arrays.fill(col, false);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (row[i] == true || col[j] == true) {
                    matrix[i][j] = 0;
                }
            }
        }
        System.out.println(Arrays.deepToString(matrix));
    }
}