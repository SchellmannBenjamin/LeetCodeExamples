import java.math.BigInteger;

public class main {
    public static void main(String[] args) {

        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        String s =""+l1.val;
        String s1 =""+ l2.val;

        int l1size = 1;
        int l2size = 1;

        String temp = "";

        ListNode tmp = l1;
        while (tmp.next!=null){
            l1size++;
            tmp = tmp.next;
            s+=tmp.val;
        }
        tmp = l2;
        while (tmp.next!=null){
            l2size++;
            tmp = tmp.next;
            s1+=tmp.val;
        }

        for (int i = s.length()-1; i >=0 ; i--) {
            temp += s.charAt(i);
        }
        s=temp;
        temp = "";
        for (int i = s1.length()-1; i >=0 ; i--) {
            temp += s1.charAt(i);
        }
        s1=temp;
        BigInteger sum = new BigInteger(s).add(new BigInteger(s1));
        s = ""+sum;
        int[] iarr = new int[s.length()];
        int i=0;
        for (char c : s.toCharArray()) {
            iarr[i++] = Character.getNumericValue(c);
        }

        ListNode returnNode = new ListNode(iarr[iarr.length-1]);
        tmp = returnNode;
        Boolean sec = true;
        for (int j = (iarr.length-2); j >=0 ; j--) {
            tmp.next = new ListNode(iarr[j]);
            if(sec)returnNode.next=tmp.next;
            tmp = tmp.next;
            sec = false;
        }

        System.out.println(returnNode.val);
        System.out.println(returnNode.next.val);
        System.out.println(returnNode.next.next.val);

    }
}
