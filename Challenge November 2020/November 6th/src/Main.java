public class Main {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int threshold = 6;

        System.out.println(smallestDivisor(nums,threshold));
    }

    public static int smallestDivisor(int[] nums, int threshold){
        int lo = 1, hi = 1000000;

        while (lo < hi){
            int mid = (lo + hi) >> 1;
            int result = cal(nums, mid);

            if(result > threshold)
                lo = mid + 1;
            else
                hi = mid;
        }
        return lo;
    }

    private static int cal(int[] nums, int div){
        int sum = 0;
        for(int n : nums){
            sum += Math.ceil((double)n / (double)div);
        }
        return (int)sum;
    }
}
