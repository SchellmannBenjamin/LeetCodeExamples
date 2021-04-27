public class Main {
    public static void main(String[] args) {

        int[] input = {5,7,7,8,8,10};
        int target = 8;
        System.out.println(searchRange(input,target));

    }

    public static int[] searchRange(int[] nums, int target){
        int start = 0;
        int end = 0;
        int pos = 0;
        boolean found = false;
        int[] retarr = {-1,-1};

        for (int num : nums) {
            if(num==target){
                if(!found)start = pos;
                found = true;
                end = pos;
            }else if(found)break;
            pos++;
        }

        if(found){
            retarr[0] = start;
            retarr[1] = end;
        }

        return retarr;
    }
}
