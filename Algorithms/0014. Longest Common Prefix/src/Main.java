public class Main {
    public static void main(String[] args) {
        String[] strings = {"ab","a"};
        System.out.println(logestCommonPrefix(strings));
    }

    public static String logestCommonPrefix(String [] strs){
        String check = "";
        String ret = "";
        boolean breakout = false;
        if(strs.length>0){
            for (int i = 0; i < strs[0].length() ; i++) {
                check += strs[0].charAt(i);
                for (int j = 0; j < strs.length; j++) {
                    try {
                        if (!strs[j].substring(0, check.length()).matches(check)) breakout = true;
                    }catch (Exception e){
                        breakout=true;
                    }
                }
                if(breakout)break;
                ret = check;

            }

        }
        return ret;
    }
}
