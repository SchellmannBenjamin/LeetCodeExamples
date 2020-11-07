public class Main {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(1);

        ListNode l4 = new ListNode(9);
        l4.next = new ListNode(9);

        addTwoNumbers(l3, l4);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode ret = new ListNode();
        ListNode addtoret = ret;
        int maxlen = 0;
        int minlen = 0;
        int l1len = 0;
        int l2len = 0;

        ListNode tmp = l1;
        ListNode tmp2 = new ListNode();

        while (tmp!=null){
            l1len++;
            tmp = tmp.next;
        }
        tmp = l2;
        while (tmp!=null){
            l2len++;
            tmp = tmp.next;
        }

        if(l1len>l2len){
            maxlen=l1len;
            minlen=l2len;
        }
        else{
            maxlen = l2len;
            minlen = l1len;
        }



        int erg = 0;
        int zw = 0;
        int count = 1;

        while (count<=l1len&&count<=l2len) {
            tmp = l1;
            tmp2 = l2;

            for (int i = l1len; i > count; i--) {
                tmp = tmp.next;
            }
            for (int i = l2len; i > count; i--) {
                tmp2 = tmp2.next;
            }

            erg = tmp.val + tmp2.val + zw;
            if(zw==1)zw=0;
            if(erg>=10){
                zw=1;
                erg=erg-10;
            }

            addtoret.val = erg;
            count++;
            erg = 0;
            if(count<=l1len&&count<=l2len) {
                addtoret.next = new ListNode();
                addtoret = addtoret.next;
            }
        }


        if(maxlen==l1len){
            tmp = l1;
            tmp2 = l1;
        }
        else{
            tmp = l2;
            tmp2 = l2;
        }

        count = 0;

        while (count<maxlen-minlen) {
            if(count == 0){
                addtoret.next = new ListNode();
                addtoret = addtoret.next;
            }

            for (int i = maxlen - minlen; i > count+1; i--) {
                tmp = tmp.next;
            }
            addtoret.val = tmp.val + zw;
            if(addtoret.val==10){
                zw=1;
                addtoret.val=0;
            }else zw = 0;
            tmp = tmp2;
            count++;
            if(count<maxlen-minlen){
                addtoret.next = new ListNode();
                addtoret = addtoret.next;
            }
        }

        if(zw == 1){
            addtoret.next = new ListNode(1);
        }
        ret = umdrehen(ret);

        System.out.println(ret.val);
        System.out.println(ret.next.val);
        System.out.println(ret.next.next.val);
        System.out.println(ret.next.next.next.val);

        return ret;

    }


    public static ListNode umdrehen(ListNode l1){
        ListNode l1tmp = l1;
        ListNode ret = new ListNode();
        ListNode retadd = ret;
        int c = 0;
        int z = 0;
        while (l1tmp!=null){
            c++;
            l1tmp = l1tmp.next;
        }
        while (z<c) {
            l1tmp = l1;
            for (int i = c; i > z+1; i--) {
                l1tmp=l1tmp.next;
            }
            retadd.val = l1tmp.val;
            z++;
            if(z<c) {
                retadd.next = new ListNode();
                retadd = retadd.next;
            }
        }
        return ret;
    }
}
