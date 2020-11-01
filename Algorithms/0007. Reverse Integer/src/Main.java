import java.util.Arrays;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        System.out.println(reverse(-187));

    }



    public static int reverse(int x){
        boolean pos = true;
        String s = "";
        String [] items = null;
        if(x<0){
            pos = false;
            x*=(-1);
        }
        s = Integer.toString(x);
        items = s.split("");
        s = "";
        for (int i = items.length-1; i >= 0 ; i--) {
            s+=items[i];
        }
        x=Integer.parseInt(s);
        if(!pos)x*=(-1);

        return x;

    }
}

