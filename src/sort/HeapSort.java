package sort;

/**
 * 堆排序（本例为大顶堆）
 * 堆是树的一种，一般树都用显示的表示方法（即用节点和左右两个指针来表示），
 * 但是在这里我们使用数组来隐式的表示这棵树，我们将根节点放在
 * 下标为 0 的地方，这样位于 n 的节点的做孩子的下标为 2n + 1 ，右孩子下标为 2n + 2 ，
 * 位于 n 的节点的父节点就是 (n - 1) / 2 号节点。
 */
public class HeapSort {
    private static void heapSort(int nums[]) {
        buildHeap(nums);
        for (int i = 0; i < nums.length; i++) {
            swap(nums, 0, nums.length - i - 1);
            compareAndSwap(nums, 0, nums.length - 2 - i);
        }
    }

    private static void buildHeap(int[] nums) {
        int lastIndex = nums.length - 1;
        int lastParent = (lastIndex - 1) / 2;
        for (int i = lastParent; i >= 0; i--) {
            compareAndSwap(nums, i, lastIndex);
        }
    }

    // 要求 index 节点的左右子树都符合堆的定义！
    private static void compareAndSwap(int[] nums, int index, int lastIndex) {
        int maxIndex;
        if (index * 2 + 1 > lastIndex) return;
        else if (index * 2 + 1 == lastIndex) maxIndex = index * 2 + 1;
        else maxIndex = nums[index * 2 + 1] > nums[index * 2 + 2] ? index * 2 + 1 : index * 2 + 2;

        maxIndex = nums[index] > nums[maxIndex] ? index : maxIndex;
        if (index == maxIndex) return;
        swap(nums, index, maxIndex);
        compareAndSwap(nums, maxIndex, lastIndex);
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,3,4,5};
        heapSort(nums);
        for (int n : nums) System.out.println(n);
    }
}
