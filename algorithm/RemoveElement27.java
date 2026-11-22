import java.util.Arrays;

public class RemoveElement27 {
    public static void main(String[] args) {
        // 测试示例
        int[] a1 = {3, 2, 2, 3};
        check("case1", a1, 3, 2, new int[]{2, 2});

        int[] a2 = {0, 1, 2, 2, 3, 0, 4, 2};
        check("case2", a2, 2, 5, new int[]{0, 1, 0, 3, 4});

        int[] a3 = {1};
        check("case3", a3, 1, 0, new int[]{});
    }

    // 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素。元素的顺序可能发生改变。然后返回 nums 中与 val 不同的元素的数量。
    public static int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) return 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != val) {
                nums[left] = nums[right];
                left++;
            }
        }
        return left;
    }

    public static void check(String name, int[] nums, int val, int expected, int[] expectedNums) {
        int result = removeElement(nums, val);

        // 取出前 result 个有效元素
        int[] actual = Arrays.copyOf(nums, result);
        Arrays.sort(actual);

        int[] expectCopy = Arrays.copyOf(expectedNums, expected);
        Arrays.sort(expectCopy);

        boolean ok = true;
        for (int i = 0; i < expected; i++) {
            if (actual[i] != expectCopy[i]) {
                ok = false;
                break;
            }
        }

        if (result != expected || !ok) {
            System.out.println(name + ": fail!");
            System.out.println("actual前k排序后：" + Arrays.toString(actual) + " actualAmount:" + result);
            System.out.println("expected排序后：" + Arrays.toString(expectCopy) + " expectedAmount:" + expected);
        } else {
            System.out.println(name + ": pass");
        }
    }
}
