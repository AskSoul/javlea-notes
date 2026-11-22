import java.util.Arrays;

public class SortedSquares977 {
    public static void main(String[] args) {
        // 测试用例
        check("case1", new int[]{-4,-1,0,3,10}, new int[]{0,1,9,16,100});
        check("case2", new int[]{-7,-3,2,3,11}, new int[]{4,9,9,49,121});
        check("case3", new int[]{0}, new int[]{0});
        check("case4", new int[]{-5,-3,-2}, new int[]{4,9,25});
        check("case5", new int[]{1,2,3}, new int[]{1,4,9});
    }

    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int left = 0;
        int right = n - 1;
        int pos = n - 1;
        while (left <= right) {
            int squareLeft = nums[left] * nums[left];
            int squareRight = nums[right] * nums[right];
            if(squareLeft >= squareRight){
                ans[pos] = squareLeft;
                left++;
            } else {
                ans[pos] = squareRight;
                right--;
            }
            pos--;
        }
        return ans;
    }

    /**
     * 校验方法：结果必须严格有序，直接数组比对
     * @param name 用例名称
     * @param nums 输入数组（升序输入）
     * @param expected 预期平方后升序结果
     */
    public static void check(String name, int[] nums, int[] expected) {
        // 注意：要传一个副本，避免原数组被别的用例干扰
        int[] inputCopy = Arrays.copyOf(nums, nums.length);
        SortedSquares977 obj = new SortedSquares977();
        int[] actual = obj.sortedSquares(inputCopy);

        boolean pass = Arrays.equals(actual, expected);
        if (pass) {
            System.out.println(name + " : pass");
        } else {
            System.out.println(name + " : fail");
            System.out.println("actual:   " + Arrays.toString(actual));
            System.out.println("expected: " + Arrays.toString(expected));
        }
    }
}
