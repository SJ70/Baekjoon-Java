import java.util.Scanner;

public class _10872 {
    public static void main(String[] args){
        System.out.println(factorial(1,new Scanner(System.in).nextInt()));
    }
    public static int factorial(int result, int n){
        if(n==0) return result;
        return factorial(result*n,n-1);
    }
}