import java.util.HashMap;
import java.util.LinkedList;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {

        ListNode l3 = new ListNode(5);
        ListNode l2 = new ListNode(4, l3);
        ListNode l1 = new ListNode(1, l2);

        ListNode t3 = new ListNode(4);
        ListNode t2 = new ListNode(3, t3);
        ListNode t1 = new ListNode(1,t2);

        ListNode u2 = new ListNode(6);
        ListNode u1 = new ListNode(2, u2);

        ListNode k1 = new ListNode();

        ListNode[] listNodes = {k1};
        System.out.println(mergeKLists(listNodes));
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        boolean corr = false;
        for (ListNode list : lists) {
            while (list!=null) {
                if (list.val != 0){
                    corr = true;
                    break;
                }
                list=list.next;
            }
        }
        if(lists.length==0||!corr)return null;
        TreeSet<Integer> nums = new TreeSet<>();
        HashMap<Integer, Integer> duplicates = new HashMap<>();
        ListNode temp = new ListNode();
        ListNode ret = temp;
        int count = 1;


        for (ListNode list : lists) {
            while (list!=null){
                if(nums.contains(list.val)){
                    if(duplicates.containsKey(list.val))
                        duplicates.put(list.val, duplicates.get(list.val)+1);
                    else duplicates.put(list.val, 1);
                }
                nums.add(list.val);
                list=list.next;
            }
        }

        for (Integer num : nums) {
            temp.val = num;
            if(duplicates.containsKey(temp.val)){
                for (int i = 0; i < duplicates.get(temp.val); i++) {
                    temp.next = new ListNode();
                    temp = temp.next;
                    temp.val = num;
                }
            }
            if(nums.size()>count) {
                temp.next = new ListNode();
                temp = temp.next;
            }
            count++;
        }

        return ret;

    }
}
