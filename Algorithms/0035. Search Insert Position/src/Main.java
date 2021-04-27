public class Main {
    public static void main(String[] args) {
        int[] input = {1,3,5,6};
        int target = 5;
        System.out.println(searchInsert(input, target));
    }

    public static int searchInsert(int[] nums, int target){
        if(nums[0]>target)return 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>=target)return i;
        }
        return nums.length;
    }
}
