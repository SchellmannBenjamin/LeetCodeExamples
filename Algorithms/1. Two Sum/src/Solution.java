class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++){
            for(int j = (i+1); j < nums.length; j++){
                if((nums[i]+nums[j])==target){
                    int[] sums = new int[2];
                    sums[0]=i;
                    sums[1]=j;
                    return sums;
                }
            }
        }
        return null;
    }
}