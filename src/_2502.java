import java.util.*;
public class _2502 {
    // 피보나치와 같은 문제 (배수가 존재하는 피보나치)
    static int[] fibo;
    static int D, RC, A, B ; // 날짜, 떡갯수, 첫날떡, 둘째날떡
    public static boolean check(){
        return RC == A * fibo[D-1] + B * fibo[D];
    }
    public static boolean checkBig(){
        return RC < A * fibo[D-1] + B * fibo[D];
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        D = sc.nextInt();
        RC = sc.nextInt();
        fibo = new int[D+1];
        fibo[0]=1;
        fibo[1]=0;
        for(int i=2; i<fibo.length; i++)
            fibo[i] = fibo[i-1] + fibo[i-2];
        //(1<=A<=B) 큰 수부터 탐색
        for(B=RC; B>=1; B--){
            for(A=1; A<=RC; A++) if(check()||checkBig()) break;
            if(check()) break;
        }
        System.out.println(A+"\n"+B);
    }
}
