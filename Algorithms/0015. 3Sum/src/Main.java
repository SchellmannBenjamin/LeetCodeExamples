import java.util.LinkedList;
import java.util.List;

public class Main {
    static List<List<Integer>> list = new LinkedList<>();
    public static void main(String[] args) {
        int[] nums = {0,3,0,1,1,-1,-5,-5,3,-3,-3,0};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums){
        for (int i = 0; i < nums.length ; i++) {
            for (int j = i+1; j < nums.length; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    if(nums[i]+nums[j]+nums[k]==0)hinzufuegen(nums[i], nums[j], nums[k]);
                }
            }
        }
        return list;
    }

    public static void hinzufuegen(int a, int b, int c){
        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(a);
        ll.add(b);
        ll.add(c);
        if(!checkDuplicates(ll))list.add(ll);
    }

    public static boolean checkDuplicates(LinkedList<Integer> ll){
        int a, b, c;
        int d = ll.get(0);
        int e = ll.get(1);
        int f = ll.get(2);
        for(List<Integer> checkList : list){
            a = checkList.get(0);
            b = checkList.get(1);
            c = checkList.get(2);
            if((a==d||a==e||a==f)&&(b==d||b==e||b==f)&&(c==d||c==e||c==f))return true;
        }
        return false;
    }
}
