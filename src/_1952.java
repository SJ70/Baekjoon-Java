import java.util.Scanner;

public class _1952 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        if(M<=N) System.out.println(M*2-2);
        else System.out.println(N*2-1);
    }
}