public class Main {
    public static void main(String[] args) {
        System.out.println(myAtoi(" "));
    }



    public static int myAtoi(String s){
        String tmp = "";
        String[] elems = s.split("");
        int x = 0;
        boolean pos = true;

        while (elems[x].equals(" ")&&x<elems.length-1)x++;
            if (elems[x].equals("+")) x++;
            else if (elems[x].equals("-")) {
                pos = false;
                x++;
            }
            try {
                if (elems[x].matches("[0-9]") && elems[x] != null) {
                    for (int i = x; i < s.length(); i++) {
                        if (elems[i].matches("[0-9]")) {
                            tmp += elems[i];
                        } else break;
                    }
                    try {
                        x = Integer.parseInt(tmp);
                    } catch (NumberFormatException e) {
                        if (pos) x = (int) Math.pow(2, 31);
                        else x = (int) Math.pow(-2, 31);
                    }

                    if (!pos) {
                        x *= (-1);
                    }
                } else return 0;
            } catch (IndexOutOfBoundsException e) {
                return 0;
        }
        return x;
    }
}
