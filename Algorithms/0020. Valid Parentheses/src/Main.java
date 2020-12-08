import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        System.out.println(isValid("){"));

    }

    public static boolean isValid(String s){
        String[] elems = s.split("");
        if(elems.length%2!=0)return false;
        LinkedList<String> mustnext = new LinkedList<>();

        for (int i = 0; i < elems.length; i++) {
            if(elems[i].equals("(")) mustnext.add(")");
            else if(elems[i].equals("[")) mustnext.add("]");
            else if(elems[i].equals("{"))mustnext.add("}");
            else if(mustnext.size()>0){
                if(!mustnext.getLast().equals(elems[i]))return false;
                else mustnext.removeLast();
            }else return false;
        }
        if(mustnext.size()>0)return false;
        return true;

    }

}
