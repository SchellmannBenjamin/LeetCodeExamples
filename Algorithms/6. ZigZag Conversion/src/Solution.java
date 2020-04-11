public class Solution {
    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 4));
    }
    public static String convert(String s, int numRows) {
        char[] input = s.toCharArray();
        char[][] zigzack = new char[s.length()][numRows];
        int yaxis = 0;
        int xaxis = 0;
        String ret = "";
        boolean flag = true;
        boolean done = false;

        for (int i = 0; i < input.length ; i++) {
            done = false;
            if(yaxis==0)flag=true;
            if(yaxis<numRows&&flag&&!done){
                zigzack[xaxis][yaxis]=input[i];
                yaxis++;
                done=true;
            }
            if(yaxis==numRows||flag==false&&!done) {
                if(yaxis==numRows)yaxis--;
                yaxis--;
                xaxis++;
                flag=false;
                zigzack[xaxis][yaxis]=input[i];
                done=true;
            }

        }
        int lmao = 0;
        for (int j = 0; j < numRows; j++) {
            for (int i = 0; i < s.length(); i++) {
                if (zigzack[i][j] != '\u0000') {
                    ret += zigzack[i][j];
                }
            }
        }

        return ret;
    }

}
