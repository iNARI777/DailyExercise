package dp;

import java.util.PriorityQueue;

public class TestUtils {
//    PriorityQueue
    public static void printMatix(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
