
class Solution {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(-1, new ListNode(1));

        System.out.println(isPalindrome(listNode));

    }

    public static boolean isPalindrome(ListNode head){
        String s = "";
        ListNode listNode = head;

        while(listNode!=null){
            s += listNode.val;
            s += ";";
            listNode = listNode.next;
        }

        String[] arr = s.split(";");

        for(int i = 0; i < arr.length; i++){
            if(arr[i].compareTo(arr[(arr.length-1)-i])!=0)return false;
        }
        return true;
    }
}
