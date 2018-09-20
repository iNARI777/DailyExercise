package dp;

/**
 * 0 - 1 背包问题 Origin type：给定一个背包的容量、 n 种货物的重量以及这 n 种货物的价值，
 * 求当前背包容量下可以装入的货物的最大价值。
 *
 * 由于一个货物只有装入（1）和不装入（0）两种状态，所以这一类的问题被命名为 0 - 1 背包问题。
 */
public class ZeroOnePack1 {
    // 限制：weight和value数组的长度是相同的
    private static int zeroOne(int volumn, int[] weight, int[] value) {
        int num = weight.length;
        int[][] dp = new int[num][volumn + 1];

        for (int i = 0; i <= volumn; i++) {
            if (weight[0] > i) dp[0][i] = 0;
            else dp[0][i] = value[0];
        }

        for (int i = 1; i < num; i++) {
            for (int j = 0; j <= volumn; j++) {
                if (weight[i] <= j) {
                    // 添加 i 号物品
                    int a = dp[i - 1][j - weight[i]] + value[i];
                    // 不添加 i 号物品（可能会剔除掉 i - 1 号物品）
                    int b = dp[i - 1][j];
                    dp[i][j] = Math.max(a, b);
                } else {
                    dp[i][j] = dp[i -  1][j];
                }
            }
        }
        return dp[num - 1][volumn];
    }

    public static void main(String[] args) {
        int value[] = {8, 10, 6, 3, 7, 2};
        int weight[] = {4, 6, 2, 2, 5, 1};
        int volumn = 12;

        int result = zeroOne(volumn,weight,value);
        System.out.println(result);
    }
}
