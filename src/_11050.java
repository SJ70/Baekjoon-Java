import java.util.Scanner;
import java.util.StringTokenizer;

public class _11050 {
    static int N,K;
    public static void main(String[] args){
        Input();
        int numerator=1;
        int denominator=1;
        for(int i=0; i<K; i++){
            numerator*=N-i;
            denominator*=K-i;
        }
        System.out.print(numerator/denominator);
    }
    public static void Input(){
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
    }
}