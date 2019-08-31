package math;

/**
 * 使用欧几里得算法求两个数的最大公约数
 */
public class GreatestCommonDivisor {
    public int getGCD(int num1, int num2) {
        if (num1 == 0 || num2 == 0) return 0;
        while (num2 != 0) {
            int temp = num2;
            num2 = num1 % num2;
            num1 = temp;
        }
        return num1;
    }

    public static void main(String[] args) {
        GreatestCommonDivisor g = new GreatestCommonDivisor();
        System.out.println(g.getGCD(20, 252));
    }
}
