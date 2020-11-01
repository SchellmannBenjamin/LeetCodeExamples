public class Main {
    public static void main(String[] args) {
        System.out.println(intToRoman(1994));
    }

    public static String intToRoman(int num){
        String s ="";
        while (num>=1000){
            s+="M";
            num-=1000;
        }
        while (num>=500){
            if(num>899){
                s+="CM";
                num -= 900;
                break;
            }
            s+="D";
            num-=500;
        }
        while (num>=100){
            if(num>399){
                s+="CD";
                num -= 400;
                break;
            }
            s+="C";
            num-=100;
        }
        while (num>=50){
            if(num>89){
                s+="XC";
                num -= 90;
                break;
            }
            s+="L";
            num-=50;
        }
        while (num>=10){
            if(num>39){
                s+="XL";
                num -= 40;
                break;
            }
            s+="X";
            num-=10;
        }
        while (num>=5){
            if(num>8){
                s+="IX";
                num -= 9;
                break;
            }
            s+="V";
            num-=5;
        }
        while (num>=1){
            if(num>3){
                s+="IV";
                num = 0;
                break;
            }
            s+="I";
            num-=1;
        }

        return s;

    }

}
