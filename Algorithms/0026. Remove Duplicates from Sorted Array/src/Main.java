import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1,1,2,3,3,4,5,6,6};
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums){
        TreeSet<Integer> set = new TreeSet<>();

        int index = 0;
        boolean duplicate = false;
        for (int num : nums) {
            set.add(num);
        }

        int[] newnums = new int[set.size()];
        for (Integer integer : set) {
            newnums[index] = integer;
            index++;
        }

        nums=newnums;

        return set.size();
    }
}
