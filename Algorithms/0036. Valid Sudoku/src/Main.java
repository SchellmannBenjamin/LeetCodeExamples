import java.util.HashMap;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        char[][] input = {{'5','3','.','.','7','.','.','.','.'}
,{'6','.','.','1','9','5','.','.','.'}
,{'.','9','8','.','.','.','.','6','.'}
,{'8','.','.','.','6','.','.','.','3'}
,{'4','.','.','8','.','3','.','.','1'}
,{'7','.','.','.','2','.','.','.','6'}
,{'.','6','.','.','.','.','2','8','.'}
,{'.','.','.','4','1','9','.','.','5'}
,{'.','.','.','.','8','.','.','7','9'}};
        System.out.println(isValidSudoku(input));
    }

    public static boolean isValidSudoku(char[][] board){
        if(checkrows(board)&&checkcolumns(board)&&checkSquares(board))return true;
        return false;
    }

    public static boolean checkSquares(char[][] board){
        HashMap<Integer, LinkedList<Integer>> map = new HashMap<>();
        int count=0;
        for (int k = 0; k < 9; k+=3) {
            for (int i = 0; i < 9; i+=3) {

                for (int j = i; j < i+3; j++) {
                    for (int l = k; l < k+3; l++) {
                        if(!map.containsKey(count))map.put(count, new LinkedList<>());
                        if(board[l][j]!='.') {
                            if (map.get(count).contains(Integer.parseInt(String.valueOf(board[l][j])))) return false;
                            map.get(count).add(Integer.parseInt(String.valueOf(board[l][j])));
                        }
                    }
                }
                count++;
            }
        }



        return true;
    }


    public static boolean checkcolumns(char[][] board){
        HashMap<Integer, LinkedList<Integer>> map = new HashMap<>();
        int count = 0;
        for (char[] chars : board) {
            for (char aChar : chars) {
                if(!map.containsKey(count))map.put(count, new LinkedList<Integer>());
                if(aChar!='.'){
                    if(map.get(count).contains(Integer.parseInt(String.valueOf(aChar))))return false;
                    map.get(count).add(Integer.parseInt(String.valueOf(aChar)));
                }
                count++;
            }
            count = 0;
        }
        return true;
    }

    public static boolean checkrows(char[][] board){
        LinkedList<Integer> list = new LinkedList<>();
        for (char[] chars : board) {
            for (char aChar : chars) {
                if(aChar!='.'){
                    if(list.contains(Integer.parseInt(String.valueOf(aChar))))return false;
                    list.add(Integer.parseInt(String.valueOf(aChar)));
                }
            }
            list.clear();
        }
        return true;
    }
}
