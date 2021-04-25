public class Main {

    public static void main(String[] args) {

        ListNode l5 = new ListNode(5);
        ListNode l4 = new ListNode(4, l5);
        ListNode l3 = new ListNode(3, l4);
        ListNode l2 = new ListNode(2, l3);
        ListNode l1 = new ListNode(1, l2);

        reverseKGroup(l1, 3);

    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode tempnode = new ListNode();
        ListNode retnode = tempnode;
        ListNode headsave = head;
        int nodecount = 0;

        while (head!=null){
            nodecount++;
            head = head.next;
        }
        head = headsave;

        for (int u = 0; u < nodecount/k; u++) {
            for (int i = 0; i < k; i++) {
                for (int j = i; j < k*(u+1) - 1; j++) {
                    head = head.next;
                }
                tempnode.val = head.val;

                if (i + 1 < k || u+1<nodecount/k) {
                    tempnode.next = new ListNode();
                    tempnode = tempnode.next;
                }else{
                    head = headsave;                                        //lazy solution
                    for (int j = 0; j < nodecount-(nodecount%k); j++) {
                        head = head.next;
                    }
                    while (head!=null){
                        tempnode.next = new ListNode(head.val);
                        head = head.next;
                        tempnode = tempnode.next;
                    }
                }
                head = headsave;
            }
        }

        return retnode;
    }
}
