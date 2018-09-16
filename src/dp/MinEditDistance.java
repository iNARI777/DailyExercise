package dp;

/**
 * 使用动态规划的方法求 *最小编辑距离*
 * 参考：https://blog.csdn.net/qq_34552886/article/details/72556242
 *
 * 自底向上，str2 和 str1 分别一个字符一个字符的添加，二维矩阵 edit[i][j] 就代表 str1(0...i - 1) 和 str2(0...j - 1)
 * 这两个子字符串之间的最小编辑距离。
 *
 * str1 或者 str2 的子串分别每添加一个字符后 edit[i][j] 的计算取下面三者中最小的一个：
 * 1. edit[i][j - 1] + 1 代表 str2(0...j - 2) 加 1 个字符的时候距离要比之前大 1
 * 2. edit[i - 1][j] + 1 代表 str1(0...1 - 2) 加 1 个字符的时候距离要比之前大 1
 * 3. edit[i - 1][j - 1] + flag 代表 str1 和 str2 都加 1 ，如果加的字符相同，那么距离不变，如果不相同，距离加 1
 *
 * 最后 edit[m][n] (矩阵的右下角) 就是两个字符串之间的最短编辑距离。
 */
public class MinEditDistance {
    private static int minEditDistance(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int[][] edit = new int[m + 1][n + 1];

        // 矩阵的第一行和第一列代表的分别是一个子字符串长度为0的情况
        for (int i = 0; i <= n; i++) {
            edit[0][i] = i;
        }
        for (int j = 0; j <= m; j++) {
            edit[j][0] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int insertStr1 = edit[i][j - 1] + 1;
                int insertStr2 = edit[i - 1][j] + 1;
                int flag = str1.charAt(i - 1) == str2.charAt(j - 1) ? 0 : 1;
                int insertSimul = edit[i - 1][j - 1] + flag;
                edit[i][j] = minValue(insertSimul, insertStr1, insertStr2);
            }
        }

        return edit[m][n];
    }

    private static int minValue(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    public static void main(String[] args) {
        String str1 = "MacOSbbcc";
        String str2 = "MacOCBbC";
        int distance = minEditDistance(str1, str2);
        System.out.println(distance);
    }
}
