import java.util.LinkedList;

public class Solution {

    public static void main(String[] args) {

        int s = lengthOfLongestSubstring(" ");
        System.out.println(s);
    }


    public static int lengthOfLongestSubstring(String s){
        LinkedList<Character> usedChars = new LinkedList();
        LinkedList<String> substrings = new LinkedList();
        char[] input = s.toCharArray();
        String substring = "";
        int ret = 0;
        int tmp = 1;

        for (int i = 0; i < input.length; i++) {
            for (Character usedChar : usedChars) {
                if(input[i] == usedChar){
                    substrings.add(substring);
                    usedChars.clear();
                    substring = "";
                    i = tmp;
                    tmp++;
                }
            }
            usedChars.add(input[i]);
            substring+=input[i];

        }
        substrings.add(substring);

        for (String substring1 : substrings) {
            if(substring1.length()>ret)ret=substring1.length();
        }

        return ret;
    }

}
