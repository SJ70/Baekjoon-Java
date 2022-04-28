import java.util.*;
public class _2908 {
    public static int ReveredInt(String str){
        return (str.charAt(2)-48)*100 + (str.charAt(1)-48)*10 + (str.charAt(0)-48);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        String B = sc.next();
        int a = ReveredInt(A);
        int b = ReveredInt(B);
        System.out.println(Math.max(a,b));
    }
}