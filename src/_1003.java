import java.util.Scanner;
public class _1003 {
    public static void main(String[] args){
        int[] fibo = new int[41];
        fibo[0]=0; fibo[1]=1;
        for(int i=2; i<41; i++){
            fibo[i]=fibo[i-1]+fibo[i-2];
        }
        Scanner sc = new Scanner(System.in);
        int rp = sc.nextInt();
        int one = 0;
        int zero = 0;
        for(int i=0; i<rp; i++){
            int n = sc.nextInt();
            if(n==0) zero=1;
            else zero=fibo[n-1];
            one=fibo[n];
            System.out.println(zero+" "+one);
        }
    }
}
