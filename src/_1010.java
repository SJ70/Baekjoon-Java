import java.util.*;
public class _1010{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i=0;i<T;i++){
            int N = sc.nextInt();
            int M = sc.nextInt();
            double result = 1;
            for(int j=0;j<N;j++){ //중복조합
                result*=(M-j);
                result/=(j+1);
            }
            System.out.println((int)result);
        }
    }
}