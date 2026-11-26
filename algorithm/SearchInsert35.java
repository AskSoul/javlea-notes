public class SearchInsert35 {
    public static void main(String[] args) {
        check("case1", new int[]{2, 3, 6, 6, 9},5,2);
        check("case2", new int[]{2, 3, 6, 6, 9},1,0);
        check("case3", new int[]{2, 3, 6, 6, 9},11,5);
        check("case4", new int[]{2, 3, 6, 6, 9},6,2);
    }

    public static int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int middle = left + ((right - left) >> 1);
            if (nums[middle] < target){
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return left;
    }

    public static void check(String name, int[] nums, int target, int expected) {
        int result = searchInsert(nums, target);
        if (result == expected) {
            System.out.println(name + ":pass");
        } else {
            System.out.println(name + ":fail expected:" + expected + " actual:" + result);
        }
    }
}
