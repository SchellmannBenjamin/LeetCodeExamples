import java.util.LinkedList;

public class Test {
    public static void main(String[] args) {
        ListNode head = new ListNode(-1);
        head.next = new ListNode(5);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(0);
        System.out.println(insertionSortList(head));
    }

    public static ListNode insertionSortList(ListNode head){
        LinkedList<Integer> ll = new LinkedList();
        LinkedList<Integer> tmp = new LinkedList<>();
        boolean inserted = false;

        while (head != null){
            ll.add(head.val);
            head = head.next;
        }

        for (int i = 0; i < ll.size()-1; i++) {
            if(ll.get(i+1)<ll.get(i)){
                for (int j = 0; j < i+1; j++) {
                    if(ll.get(j)<ll.get(i+1)&&!inserted)tmp.add(ll.get(j));
                    else if(ll.get(j)>=ll.get(i+1)&&!inserted){
                        inserted=true;
                        tmp.add(ll.get(i+1));
                        tmp.add(ll.get(j));
                    }
                    if(inserted) {
                        try {
                            if (ll.get(i + 2) != null) {
                                while (j<i){
                                    j++;
                                    tmp.add(ll.get(j));
                                }
                                for (int k = i + 2; k < ll.size(); k++) {
                                    tmp.add(ll.get(k));
                                }
                            }
                            ll.clear();
                            for (int k = 0; k < tmp.size(); k++) {
                                ll.add(tmp.get(k));
                            }
                            i = 0;
                            inserted = false;
                            tmp.clear();
                            break;
                        }catch (Exception e){
                            ll = getNewList(tmp);
                        }
                    }
                }
            }
        }

        return toListNode(ll);

    }

    public static LinkedList<Integer> getNewList(LinkedList<Integer> tmp){
        LinkedList<Integer> ret = new LinkedList<>();
        for (int i = 0; i < tmp.size(); i++) {
            ret.add(tmp.get(i));
        }
        return ret;
    }

    public static ListNode toListNode(LinkedList<Integer> ll){
        ListNode head = new ListNode(ll.get(0));
        ListNode ret = head;
        for (int i = 1; i < ll.size(); i++) {
            head.next = new ListNode(ll.get(i));
            head = head.next;
        }
        return ret;
    }
}
