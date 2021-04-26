import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {

        String[] words = {"foo", "bar"};
        System.out.println(findSubstring("foobarfoobar", words));

    }

    public static List<Integer> findSubstring(String s, String[] words){
        LinkedList<String> containslist = new LinkedList<>();
        TreeSet<Integer> retlist = new TreeSet<>();
        LinkedList<Integer> kekW = new LinkedList<>();
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
                        else if(charword.length>j){
                            matches=false;
                        }
                    }
                    if(matches)retlist.add(i);
                    matches=true;
                }
            }
        }

        for (Integer integer : retlist) {
            kekW.add(integer);
        }

        return kekW;
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
        return retwords;
    }

    public static LinkedList<LinkedList<String>> permute(String[] words){
        LinkedList<LinkedList<String>> list = new LinkedList<>();
        Arrays.sort(words);
        permuteData(list, new LinkedList<>(), words, new boolean[words.length]);
        return list;
    }



    public static void permuteData(LinkedList<LinkedList<String>> list, LinkedList<String> resultList, String[] words, boolean[] used){
        if(resultList.size()==words.length)list.add(new LinkedList<>(resultList));
        else{
            for (int i = 0; i < words.length; i++) {
                if(used[i] || i > 0 && words[i] == words[i-1] && !used[i-1])continue;
                used[i]=true;
                resultList.add(words[i]);
                permuteData(list, resultList, words, used);
                used[i]=false;
                resultList.remove(resultList.size()-1);
            }
        }
    }
}
