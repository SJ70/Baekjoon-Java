import java.util.Scanner;

public class _15259 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str;
        while(!(str=sc.nextLine()).equals("0")){
            System.out.println(isPalindrome(str)?"yes":"no");
        }
    }
    public static boolean isPalindrome(String str){
        for(int i=0; i<str.length()/2; i++){
            if(str.charAt(i)!=str.charAt(str.length()-1-i)) return false;
        }
        return true;
    }
}
