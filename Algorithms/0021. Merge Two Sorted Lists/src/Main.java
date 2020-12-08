public class Main {
    public static void main(String[] args) {

        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        mergeTwoLists(l1, l2);

    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode ret = new ListNode();
        ListNode retSave = ret;
        ListNode addLast = new ListNode();
        if(l1==null&&l2==null)return null;

        while (l1!=null&&l2!=null){
            if(l1.val<=l2.val){
                ret.val = l1.val;
                ret.next = new ListNode();
                ret = ret.next;
                l1 = l1.next;
            }else{
                ret.val = l2.val;
                ret.next = new ListNode();
                ret = ret.next;
                l2 = l2.next;
            }
        }

        if(l1!=null&&l2==null){
            addLast = l1;
        }else if(l1==null&&l2!=null){
            addLast = l2;
        }

        while (addLast!=null){
            ret.val = addLast.val;
            addLast = addLast.next;
            if(addLast!=null){
                ret.next = new ListNode();
                ret = ret.next;
            }
        }

        return retSave;
    }
}
