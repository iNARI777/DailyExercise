package dp;

/**
 * 给定一个数组，求该数组和最大的子序列的和的值，小于 0 的话返回 0 。
 *
 * 假设前 n - 1 个元素的最大子序列的和为 maxSeq 是已经求出来了的，那么新加入的第 n 个元素的时候有我们需要关注
 * 两个地方：一个是最大子序列的和以及序列末尾的某个序列的和，末尾序列的和在加入新元素之后是有可能大于 maxSeq的。
 * 1. 加入之后没有之前的 maxSeq 大，这个时候 maxSeq 不变，同时要注意保存尾序列的状态：
 *      * 如果尾序列的和小于 0 ，证明这个尾序列加上之后的元素也不可能是最大子序列，所以这个时候将 sumTail = 0
 *      * 如果尾序列和大于 0 ，那么在加入后续元素之后它还是有可能成为最大子序列的。
 * 2. 如果加入新元素之后大于 maxSeq 了，将 maxSeq = sumTail 就行。
 */
public class MaxSubsequnce {
    private static int maxSubsequnce(int[] nums) {
        int maxSeq = 0;
        int sumTail = 0;

        for (int i = 0; i < nums.length; i++) {
            if (maxSeq > sumTail + nums[i]) {
                sumTail = sumTail + nums[i] > 0 ? sumTail + nums[i] : 0;
            } else {
                sumTail += nums[i];
                maxSeq = sumTail;
            }
        }

        return maxSeq;
    }
}
