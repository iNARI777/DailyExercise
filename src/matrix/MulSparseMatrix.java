package matrix;

import java.util.Arrays;

public class MulSparseMatrix {
    private static int[][] mulSparseMatrix(int[][] a, int[][] b) {
        assert a.length > 0 && a[0].length > 0;
        assert b.length > 0 && b[0].length > 0;
        assert a[0].length == b.length;

        int[][] result = new int[a[0].length][b[0].length];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (a[i][j] != 0) {
                    for (int k = 0; k < b[0].length; k++) {
                        result[i][k] += a[i][j] * b[j][k];
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] a = {{0,0,1,1}, {0,0,0,1}, {0,1,0,0}};
        int[][] b = {{1,0}, {0,0}, {1,1}, {0,1}};
        int[][] result = mulSparseMatrix(a, b);

        for (int i = 0; i < result.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }
    }
}
