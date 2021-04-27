
public class Main {

    public static void main(String[] args) {
        int[] input = {4,5,6,7,0,1,2};
        System.out.println(search(input, 0));
    }

    public static int search(int[] nums, int target){
        int count = 0;
        boolean found = false;
        for (int num : nums) {
            if(num==target){
                found = true;
                break;
            }
            count++;
        }

        if(found)return count;
        return -1;
    }
}
