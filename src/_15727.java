import java.util.Scanner;

public class _15727 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int result = N/5;
        if(N%5>0) result++;
        System.out.println(result);
    }
}