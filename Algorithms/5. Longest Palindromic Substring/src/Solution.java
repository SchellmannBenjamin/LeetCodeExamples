import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }

    public static String longestPalindrome(String s) {
        LinkedList<String> palindromes = new LinkedList<>();
        String tmp = "";
        char[] input = s.toCharArray();

        for (int i = 0; i < input.length; i++) {
            tmp+=input[i];
            if(tmp.compareTo())

        }

    }


}
