import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }

    public static String longestPalindrome(String s) {

        LinkedList<String> palindromes = new LinkedList<>();
        String tmp = "";
        char[] input = s.toCharArray();

        for(int j = 0; j < input.length; j++) {
            tmp = "";
            for (int i = 0+j; i < input.length; i++) {
                tmp += input[i];
                if (tmp.compareTo(umdrehen(tmp)) == 0) palindromes.add(tmp);
            }
        }
        for (String palindrome : palindromes) {
            if(tmp.length()<palindrome.length())tmp = palindrome;
        }
        return tmp;
    }

    public static String umdrehen(String s) {
        String ret = new String();
        for (int i = s.length() - 1; i >= 0; i--) {
            ret+=s.charAt(i);
        }
        return ret;
    }


}

