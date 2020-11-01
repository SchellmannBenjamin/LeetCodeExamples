public class Solution {

    public static void main(String[] args) {

        System.out.println(isPalindrome("aba"));
        System.out.println(isPalindrome("abca"));
        System.out.println(isPalindrome("keka"));

    }

    public static boolean isPalindrome(String s){
        int count = 0;
        String tmp = "";
        char[] splitted = s.toCharArray();

        for (int i = 0; i < splitted.length; i++){
            if(Character.isLetter(splitted[i]))tmp += splitted[i];
        }
        tmp = tmp.toLowerCase();
        char[] onlyChars = tmp.toCharArray();

        for(int i = 0; i < onlyChars.length; i++){
            if(onlyChars[i] != onlyChars[(onlyChars.length-1)-i]){
                count++;
                if(count>2)return false;
            }
        }
        return true;
    }

}
