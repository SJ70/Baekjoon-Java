import java.util.Scanner;

public class _2231 {
    public static int Decompose(int N){
        return N+N/1000000+N%1000000/100000+N%100000/10000+N%10000/1000+N%1000/100+N%100/10+N%10;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int i = 0;
        while(++i<=1000000){
            if(Decompose(i)==N){
                System.out.println(i);
                break;
            }
        }
        if(i==1000001) System.out.println(0);
    }
}
