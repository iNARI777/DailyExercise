package math;

/**
 * 求同余幂，即求 a^n mod m 的快速算法
 * 主要用了一个定理，就是 n1 * n2 * ... * nn mod m == n1 mod m * n2 mod m * ... * nn mod m
 * 算法的实质就是按照上面的定理，把 a^n 中的 n 拆成若干个 2^nn ，每一步都模 m ，使得每一步的结果不会非常大
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
            power = (power * power) % m;    // 注意这里也要模m
            mask <<= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(getCongruencePower(2, 644, 645));
    }
}
