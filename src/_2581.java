import java.util.Scanner;

public class _2581 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        if(M==1) M=2;
        int N = sc.nextInt();
        int sum = 0;
        int min = -1;
        for(int i=M; i<=N; i++){
            if(!canDivide(i)){
                sum+=i;
                if(min==-1) min=i;
            }
        }
        if(sum==0) System.out.println(-1);
        else System.out.printf("%d\n%d",sum,min);
    }
    public static boolean canDivide(int N){
        for(int i=2; i<N; i++){
            if(N%i==0) return true;
        }
        return false;
    }
}
