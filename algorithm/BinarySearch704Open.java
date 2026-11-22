public class BinarySearch704Open {
    public static void main(String[] args) {
        // 测试用例
        int[] nums1 = {1,3,5,7,9};
        int[] nums2 = {5};
        int[] nums3 = {};
        check("case1", nums1, 5, 2);
        check("case2", nums1,1, 0);
        check("case3", nums1,9,4);
        check("case4", nums1,0,-1);
        check("case5", nums1,10,-1);
        check("case6", nums2,5,0);
        check("case7", nums2,3,-1);
        check("case8", nums3,1,-1);
    }

    public static int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            }  else if (nums[mid] < target) {
                low = mid + 1;
            }  else {
                high = mid;
            }
        }
        return -1;
    }

    public static void check(String name, int[] nums, int target, int expected) {
        int result = search(nums, target);
        if (result == expected) {
            System.out.println(name + ":" + "pass");
        } else {
            System.out.println(name + ":" + "fail" + "  | target=" + target + " expected=" + expected + " result=" + result);
        }
    }
}
