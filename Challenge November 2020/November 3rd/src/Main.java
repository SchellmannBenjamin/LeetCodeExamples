public class Main {
    public static void main(String[] args) {
        System.out.println(maxPower("halooo"));
    }

    public static int maxPower(String s){
        int erg = 1;
        int tmp = 1;
        String temp = "";
        String [] chars = s.split("");
        for (int i = 0; i < chars.length; i++) {
            temp = chars[i];
            if(i+1<chars.length){
                for (int j = i+1; j <chars.length; j++) {
                    if (temp.equals(chars[j])) {
                        tmp++;
                        if(tmp > erg)erg = tmp;
                    }else{
                        tmp = 1;
                        break;
                    }
                }
                tmp = 1;
            }
        }
        return erg;
    }
}
