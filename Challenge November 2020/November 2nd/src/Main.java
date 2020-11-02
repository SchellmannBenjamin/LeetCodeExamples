import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

public class Main{
    static HashMap<Integer, Integer> hashMap = new HashMap();
    public static void main(String[] args) {
        ListNode head = new ListNode(-1);
        head.next = new ListNode(5);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(0);

        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(1);
        System.out.println(insertionSortList(listNode));
    }
    public static ListNode insertionSortList(ListNode head){
        TreeSet<Integer> treeSet = new TreeSet<>();

        while (head != null){
            treeSet.add(head.val);
            if(hashMap.containsKey(head.val)){
                hashMap.put(head.val, hashMap.get(head.val)+1);
            }else hashMap.put(head.val, 1);

            head = head.next;
        }

        return toListNode(treeSet);
    }

    public static ListNode toListNode(TreeSet<Integer> ts){
        boolean b = true;
        boolean empty = false;
        if(!ts.isEmpty()){
            ListNode head = null;
            ListNode tmp = null;
            while (!ts.isEmpty()){
                if(b) {
                    head = new ListNode(ts.pollFirst());
                    tmp = head;
                    for (int i = 1; i < hashMap.get(head.val); i++) {
                        head.next = new ListNode(head.val);
                        head = head.next;
                    }
                    b = false;
                }

                try {
                    head.next = new ListNode(ts.pollFirst());
                    head = head.next;
                }catch (Exception e){empty = true;}
                if(!empty) {
                    for (int i = 1; i < hashMap.get(head.val); i++) {
                        head.next = new ListNode(head.val);
                        head = head.next;
                    }
                }
                empty = false;
            }
            return tmp;
        }else return null;
    }
}