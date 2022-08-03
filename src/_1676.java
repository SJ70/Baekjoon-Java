import java.math.BigInteger;
import java.util.Scanner;

public class _1676 {
    public static void main(String[] args){
        int N = new Scanner(System.in).nextInt();
        BigInteger X = new BigInteger("1");
        // 0!일 경우 그냥 1
        for(int i=2; i<=N; i++){
            X = X.multiply(new BigInteger(String.valueOf(i)));
        }
        String str = X.toString();
        int result = 0;
        for(int i=str.length()-1; i>=0; i--){
            if(str.charAt(i)=='0') result++;
            else break;
        }
        System.out.println(result);
    }
}