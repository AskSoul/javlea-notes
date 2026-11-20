public class BinarySearch704 {
    public static void main(String[] args) {
        // 测试用例
        int[] nums1 = {1,3,5,7,9};
        int[] nums2 = {5};
        int[] nums3 = {};
        search(nums1,5);
        search(nums1,1);
        search(nums1,9);
        search(nums1,0);
        search(nums1,10);
        search(nums2,5);
        search(nums2,3);
        search(nums3,1);

    }
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void check(String name, int[] nums, int target, int expected) {
        // 这里先空着
    }
}
