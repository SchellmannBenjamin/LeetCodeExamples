public class Solution {
    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
    }
    public static String convert(String s, int numRows) {
        char[] input = s.toCharArray();
        char[][] zigzack = new char[s.length()/numRows][numRows];
        int tmp = 0;

        for (int i = 0; i < input.length ; i++) {
            if(tmp<numRows)zigzack[tmp/numRows][tmp]=input[i];
            if(tmp==numRows) {
                zigzack[][]=input[i];
            }

            tmp++;
        }
        return "";
    }

}
