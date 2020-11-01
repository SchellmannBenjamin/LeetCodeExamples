public class Main {
    public static void main(String[] args) {
        System.out.println(isMatch("mississippi", "mis*is*p*."));
    }

    public static boolean isMatch(String s, String p){
        if(s.matches(p))return true;
        else return false;
    }
}
