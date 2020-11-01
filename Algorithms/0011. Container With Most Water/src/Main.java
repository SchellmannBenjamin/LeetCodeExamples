public class Main {

    public static void main(String[] args) {
        int[] a = {1,8,6,2};
        System.out.println(maxArea(a));
    }

    public static int maxArea(int[] height){
        int erg = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = height.length-1; j >= 0 ; j--) {
                if(j>i){
                    if(height[i]>=height[j]) {
                        if(erg<height[j]*(j-i))erg=height[j]*(j-i);
                    }else{
                        if(erg<height[i]*(j-i))erg=height[i]*(j-i);
                    }
                }
            }
        }
        return erg;
    }
}
