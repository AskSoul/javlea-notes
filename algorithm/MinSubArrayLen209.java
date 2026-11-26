import java.util.Arrays;

public class MinSubArrayLen209 {
    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        int[] num = {5};
        check("case11", nums, 7, 2);
        check("case12", nums, 16, 0);
        check("case13", nums, 8, 3);
        check("case14", nums, 11, 5);
        check("case15", num, 5, 1);
        check("case21", minSubArrayLenPreSumBinarySearch(7, nums) == 2);
        check("case22", minSubArrayLenPreSumBinarySearch(16, nums) == 0);
        check("case31", minSubArrayLenSlidingWindow(7, nums) == 2);
        check("case32", minSubArrayLenSlidingWindow(16, nums) == 0);
    }

    public static int minSubArrayLenForce(int target, int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum >= target) {
                    ans = Math.min(ans, j - i + 1);
                    break;
                }
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public static int minSubArrayLenPreSumBinarySearch(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int[] sums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        for (int i = 1; i <= n; i++) {
            int target = s + sums[i - 1];
            int bound = Arrays.binarySearch(sums, target);
            if (bound < 0) {
                bound = -bound - 1;
            }
            if (bound <= n) {
                ans = Math.min(ans, bound - (i - 1));
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public static int minSubArrayLenSlidingWindow(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int ans = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int sum = 0;
        while (end < n) {
            sum += nums[end];
            while (sum >= s) {
                ans = Math.min(ans,end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public static void check(String name, int[] nums, int target, int expected) {
        int result = minSubArrayLenForce(target, nums);
        if (result == expected) {
            System.out.println(name + ":pass");
        }  else {
            System.out.println(name + ":fail expected:" + expected + " actual:" + result);
        }
    }

    public static void check(String name, boolean b) {
        if (b) {
            System.out.println(name + ":pass");
        }  else {
            System.out.println(name + ":fail");
        }
    }
}
