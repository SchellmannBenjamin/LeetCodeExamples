import com.sun.org.apache.xml.internal.resolver.readers.ExtendedXMLCatalogReader;
import sun.awt.image.ImageWatched;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    static  List<String> ret = new ArrayList<String>();
    static HashMap<String, String> charsMap = new HashMap<String, String>(){{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

    public static List<String> letterCombinations(String digits){
        if(digits.length() != 0){
            backtrack("", digits);
            return ret;
        }
        return null;
    }

    public static void backtrack(String combination, String next_digits) {
        if (next_digits.length() == 0) {
            ret.add(combination);
        } else {
            String digit = next_digits.substring(0, 1);
            String letters = charsMap.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                String letter = charsMap.get(digit).substring(i, i + 1);
                backtrack(combination + letter, next_digits.substring(1));
            }
        }
    }


}
