public class Main {

    public static void main(String[] args) {

        ListNode l5 = new ListNode(5);
        ListNode l4 = new ListNode(4, l5);
        ListNode l3 = new ListNode(3, l4);
        ListNode l2 = new ListNode(2, l3);
        ListNode l1 = new ListNode(1, l2);

        swapPairs(l1);
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode retnode = new ListNode();
        ListNode nodesave = retnode;
        int tempsave = 0;

        if(head == null)return null;
        if(head.next==null)return head;

        while (head.next!=null){
            tempsave = head.val;
            head = head.next;
            retnode.val = head.val;
            retnode.next = new ListNode(tempsave);
            retnode = retnode.next;
            if(head.next!=null){
                head = head.next;
                retnode.next = new ListNode();
                retnode=retnode.next;

                if(head.next==null){
                    retnode.val = head.val;
                    break;
                }
            }
        }

        while (nodesave!=null){
            System.out.println(nodesave.val);
            nodesave=nodesave.next;
        }

        return nodesave;
    }
}
