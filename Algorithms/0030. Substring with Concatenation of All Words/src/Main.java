import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        String[] words = {"word", "good", "good", "best"};
        System.out.println(findSubstring("wordgoodgoodgoodbestword", words));

    }

    public static List<Integer> findSubstring(String s, String[] words){
        LinkedList<String> containslist = new LinkedList<>();
        LinkedList<Integer> retlist = new LinkedList<>();
        String[] wordlist = wordcombinations(words);
        boolean matches = true;

        char[] chars = s.toCharArray();
        char[] charword;

        for (String s1 : wordlist) {
            if(s.contains(s1))containslist.add(s1);
        }

        for (String s1 : containslist) {
            charword = s1.toCharArray();
            for (int i = 0; i < s.length(); i++) {
                if(charword[0]==chars[i]){
                    for (int j = 1; j < s1.length(); j++) {
                        if(i+j<chars.length) {
                            if (chars[i + j] != charword[j]) {
                                matches = false;
                                break;
                            }
                        }
                    }
                    if(matches)retlist.add(i);
                    matches=true;
                }
            }
        }

        return retlist;
    }

    public static String[] wordcombinations(String[] words){
        LinkedList<LinkedList<String>> list = permute(words);
        String[] retwords = new String[list.size()];
        String temp = "";
        int count = 0;
        for (LinkedList<String> combinationlist: list) {
            for (String s : combinationlist) {
                temp += s;
            }
            retwords[count] = temp;
            temp = "";
            count++;
        }

        for (String retword : retwords) {
            System.out.println(retword);
        }
        return retwords;
    }

    public static LinkedList<LinkedList<String>> permute(String[] words){
        LinkedList<LinkedList<String>> list = new LinkedList<>();
        permuteData(list, new LinkedList<>(), words);
        return list;
    }

    public static LinkedList<String> checkduplicate(String[] words, String word){
        LinkedList<String> duplicates = new LinkedList<>();
        for (int i = 0; i < words.length; i++) {
            if(words[i].equals(word))duplicates.add(words[i]);
        }
        return duplicates;
    }

    public static void permuteData(LinkedList<LinkedList<String>> list, LinkedList<String> resultList, String[] words){
        LinkedList<String> duplicates = new LinkedList<>();
        if(resultList.size()==words.length)list.add(new LinkedList<>(resultList));
        else{
            for (int i = 0; i < words.length; i++) {
                duplicates = checkduplicate(words, words[i]);
                if(resultList.contains(words[i]))continue;
                resultList.add(words[i]);
                permuteData(list, resultList, words);
                resultList.remove(resultList.size()-1);
            }

        }
    }
}
