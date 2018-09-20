package dp;

/**
 * 恰好装满背包的问题，在一篇网上的博客《背包问题九讲》中将其与 0 - 1 背包问题归为了一类，
 * 将其视为 0 - 1 背包问题的变种。
 *
 * 这个问题就是给定了背包的容量 volume 以及一组货物的重量 weight[] ，每种货物的数量不限，
 * 让你求出恰好装满背包有几种方法。
 */
public class JustFullPack {
    private static int justFullPack(int volume, int[] weight) {
        int num = weight.length;
        int[][] dp = new int[num][volume + 1];

        for (int i = 1; i <= volume; i++) {
            dp[0][i] = i % weight[0] == 0 ? 1 : 0;
        }
        for (int i = 0; i < num; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < num; i++) {
            for (int j = 1; j <= volume; j++) {     // 容量为 0 没意义，从 1 开始计算
                if (weight[i] <= j) {
                    dp[i][j] = dp[i][j - weight[i]] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[num - 1][volume];
    }

    public static void main(String[] args) {
        int volume = 8;
        int[] weight = {1,2,3};

        int result = justFullPack(volume, weight);
        System.out.println(result);
    }


}
