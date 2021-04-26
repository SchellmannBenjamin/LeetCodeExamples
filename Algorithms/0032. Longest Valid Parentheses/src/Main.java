public class Main {

    public static void main(String[] args) {
        String check = "()(()";
        System.out.println(longestValidParentheses(check));
    }

    public static int longestValidParentheses(String s) {
        int offen = 0;
        int temp = 0;
        int longest = 0;
        char[] chars = s.toCharArray();


        for (int i = 0; i < chars.length; i++) {
            if(chars[i]=='('){
                offen++;
            }else{
                if(offen==0||offen>1){
                    if(temp > longest)longest = temp;
                    temp = 0;
                }else{
                    temp+=2;
                    offen--;
                }

            }
        }
        if(temp > longest) longest = temp;

        return longest;
    }

}
