import sun.awt.image.ImageWatched;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.TreeSet;

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
        char[][] output = solveSudoku(input);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(output[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static char[][] solveSudoku(char[][] board){
        HashMap<Integer, LinkedList<Integer>> squares = getSquares(board);
        HashMap<Integer, LinkedList<Integer>> columnsMap = getcolumns(board);
        HashMap<Integer, LinkedList<Integer>> rowsMap = getrows(board);

        TreeSet<Integer> set = new TreeSet<>();

        int square = 0;
        boolean filled = false;
    while (!filled) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (Integer num : rowsMap.get(i)) {
                        set.add(num);
                    }
                    for (Integer num : columnsMap.get(j)) {
                        set.add(num);
                    }

                    if (i < 6 && i > 2) {
                        square += 3;
                    } else if (i < 9 && i > 5) {
                        square += 6;
                    }
                    if (j < 6 && j > 2) {
                        square++;
                    } else if (j < 9 && j > 5) {
                        square += 2;
                    }

                    for (Integer num : squares.get(square)) {
                        set.add(num);
                    }

                    if (set.size() == 8) {
                        System.out.println("solution found at: row: " + i + " column: " + j);
                        System.out.println();
                        for (int k = 1; k < 10; k++) {
                            if (!set.contains(k)) {
                                System.out.println(k);
                                board[i][j] = (char)(k+'0');

                                squares.get(square).add(k);
                                rowsMap.get(i).add(k);
                                columnsMap.get(j).add(k);
                            }
                        }
                    }


                    square = 0;
                    set.clear();

                    filled = checkfilled(board);
                }
            }
        }
    }


        return board;
    }

    public static boolean checkfilled(char[][] board){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(board[i][j]=='.')return false;
            }
        }
        return true;
    }

    public static HashMap<Integer, LinkedList<Integer>> getSquares(char[][] board){
        HashMap<Integer, LinkedList<Integer>> map = new HashMap<>();
        int count=0;
        for (int k = 0; k < 9; k+=3) {
            for (int i = 0; i < 9; i+=3) {

                for (int j = i; j < i+3; j++) {
                    for (int l = k; l < k+3; l++) {
                        if(!map.containsKey(count))map.put(count, new LinkedList<>());
                        if(board[l][j]!='.') {
                            map.get(count).add(Integer.parseInt(String.valueOf(board[l][j])));
                        }
                    }
                }
                count++;
            }
        }

        return map;
    }


    public static HashMap<Integer, LinkedList<Integer>> getcolumns(char[][] board){
        HashMap<Integer, LinkedList<Integer>> map = new HashMap<>();
        int count = 0;
        for (char[] chars : board) {
            for (char aChar : chars) {
                if(!map.containsKey(count))map.put(count, new LinkedList<>());
                if(aChar!='.'){
                    map.get(count).add(Integer.parseInt(String.valueOf(aChar)));
                }
                count++;
            }
            count = 0;
        }
        return map;
    }

    public static HashMap<Integer, LinkedList<Integer>> getrows(char[][] board){
        HashMap<Integer, LinkedList<Integer>> map = new HashMap<>();
        int count = 0;
        for (char[] chars : board) {
            for (char aChar : chars) {
                if(aChar!='.'){
                    if(!map.containsKey(count))map.put(count, new LinkedList<>());
                    map.get(count).add(Integer.parseInt(String.valueOf(aChar)));
                }
            }
            count++;
        }
        return map;
    }
}
