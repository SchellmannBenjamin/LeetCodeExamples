public class Solution {

    public static void main(String[] args) {

        System.out.println(isPalindrome(12321));

    }

    public static boolean isPalindrome(int x){
        String s = Integer.toString(x);

        String[] arr = s.split("");
        String[] reverse = new String[arr.length];
        
        for(int i = 0; i < arr.length; i++)
            reverse[i]=arr[(arr.length-1)-i];

        for(int i = 0; i < arr.length; i++){
            if(arr[i].compareTo(reverse[i])!=0)return false;
        }
        return true;
    }

}
