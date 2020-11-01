import java.util.HashMap;

public class Main {
    public static HashMap<String, Integer> romanwerte = new HashMap<>();
    public static void main(String[] args) {
        initMap();
        System.out.println(intToRoman("MCMXCIV"));
    }

    public static int intToRoman(String s) {
        int erg = 0;
        String [] elems = s.split("");
        for (int i = 0; i < elems.length ; i++) {
            if(i+1<elems.length&&romanwerte.get(elems[i+1])>romanwerte.get(elems[i])){
                    erg-=romanwerte.get(elems[i]);
                    erg+=romanwerte.get(elems[i+1]);
                    i++;
            }else erg += romanwerte.get(elems[i]);
        }

        return erg;
    }


    public static void initMap(){
        romanwerte.put("M", 1000);
        romanwerte.put("D", 500);
        romanwerte.put("C", 100);
        romanwerte.put("L", 50);
        romanwerte.put("X", 10);
        romanwerte.put("V", 5);
        romanwerte.put("I", 1);
    }
}
