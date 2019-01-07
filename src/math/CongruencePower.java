package math;

/**
 * 求同余幂，即求 a^n mod m 的快速算法
 * 主要用了一个定理，就是 n1 * n2 * ... * nn mod m == n1 mod m * n2 mod m * ... * nn mod m
 *
 */
public class CongruencePower {
    public static int getCongruencePower(int a, int n, int m) {
        int mask = 1;
        int result = 1;
        int power = a % m;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                result = (result * power) % m;
            }
            power = (power * power) % m;    // 注意这里也要模m，因为
            mask <<= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(getCongruencePower(2, 644, 645));
    }
}
