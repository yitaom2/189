import java.util.Arrays;

public class code1_7 {
    public static void main(String[] args) {
        Integer[][] check = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        rotate(check);
    }

    public static void rotate(Integer[][] image) {
        for (int i = 0; i < image.length / 2; i++) {
            for (int j = i; j < image.length - 1 - i; j++) {
                int N_1 = image.length - 1;
                int node_1 = image[i][j];
                int node_2 = image[j][N_1 - i];
                int node_3 = image[N_1 - i][N_1 - j];
                int node_4 = image[N_1 - j][i];

                image[i][j] = node_4;
                image[j][N_1 - i] = node_1;
                image[N_1 - i][N_1 - j] = node_2;
                image[N_1 - j][i] = node_3;
            }
        }
        System.out.println(Arrays.deepToString(image));
    }
}