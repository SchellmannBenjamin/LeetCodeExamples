public class Main {
    public static void main(String[] args) {

        System.out.println(strStr("mississippi", "issip"));

    }

    public static int strStr(String haystack, String needle){
        if(needle.length()==0)return 0;
        boolean needlefound = true;

        char[] charhaystack = haystack.toCharArray();
        char[] charneedle = needle.toCharArray();

        if(haystack.contains(needle)){
            for (int i = 0; i < haystack.length(); i++) {
                if(charhaystack[i]==charneedle[0]){
                    for (int j = 1; j < needle.length(); j++) {
                            if (charhaystack[i + j] != charneedle[j]) {
                                needlefound = false;
                                break;
                            }
                    }
                    if(needlefound) return i;
                    needlefound = true;
                }
            }
        }
        return -1;
    }
}
