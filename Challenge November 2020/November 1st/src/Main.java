public class Main {



    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(0);
        head.next.next = new ListNode(1);

        System.out.println(getDecVal(head));
    }

    public static int getDecVal(ListNode head){
        String s = "";
        int multiplier = 1;
        int decVal = 0;

        while (head!=null){
            s+=head.val;
            head=head.next;
        }
        String [] items = s.split("");
        for (int i = items.length-1; i >= 0 ; i--) {
            decVal += multiplier*Integer.parseInt(items[i]);
            multiplier*=2;
        }

        return decVal;
    }

}
