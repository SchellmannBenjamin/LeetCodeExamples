public class Main {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        removeNthFromEnd(head,2);

    }

    public static ListNode removeNthFromEnd(ListNode head, int n){
        ListNode headsave = head;
        int len = 1;
        int lensave = 0;
        ListNode tmp1 = new ListNode();
        ListNode tmp2 = new ListNode();
        ListNode ret;

        while (head.next!=null){
            head=head.next;
            len++;
        }
        head = headsave;
        lensave = len;

        len -= n;
        tmp1 = head;
        while (len>0){
            tmp1 = tmp1.next;
            len--;
        }
        len = lensave;

        ret = head;
        ListNode retsave = ret;
        len-=n+1;
        for (int i = len; i > 0; i--) {
            ret.next = new ListNode();
            ret = ret.next;
            head = head.next;
            ret = head;
        }



        System.out.println(ret.val);

        return head;
    }
}
