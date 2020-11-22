public class Solution {
    public static void main(String[] args) {
        System.out.println(convert("A", 1));
    }
    public static String convert(String s, int numRows) {
        char[] input = s.toCharArray();
        char[][] zigzack = new char[s.length()][numRows];
        int start = 0;
        int i = 0;
        int count = 0;

        while (start<input.length) {
            if(numRows<=1)return s;
            if(i%(numRows-1)==0) {
                zigzack = untereinander(input, i, numRows, zigzack, start);
                start = newStart(start, numRows, i);
                i++;
                count=0;
            }else{
                zigzack=nebeneinander(input, i, numRows, zigzack, start, count);
                start=newStart(start, numRows, i);
                i++;
                count++;
            }
        }



        return toFinalString(zigzack, numRows, input.length);

    }

    public static String toFinalString(char[][] zigzack, int numRows, int length){
        String s = "";

        for (int j = 0; j < numRows; j++) {
            for (int i = 0; i < length; i++) {
                if (zigzack[i][j] != 0) s += zigzack[i][j];
            }
        }

        return s;
    }

    public static char[][] nebeneinander(char[] input, int reihe, int anz, char[][] retarray, int start, int count){
        int height = anz-(count+2);
        if(start<input.length) retarray[reihe][height] = input[start];
        else return retarray;
        return retarray;
    }


    public static char[][] untereinander(char[] input, int reihe, int anz, char[][] retarray, int start){
        for (int i = 0; i < anz; i++) {
            if(start<input.length)retarray[reihe][i] = input[start];
            else return retarray;
            start++;
        }
        return retarray;
    }

    public static int newStart(int start, int numrows, int reihe){
        if(reihe%(numrows-1)==0)start+=numrows;
        else start++;
        return start;
    }

}
