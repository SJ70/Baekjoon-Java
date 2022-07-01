import java.math.BigInteger;
import java.util.Scanner;

public class _2407 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        BigInteger A = new BigInteger("1");
        BigInteger B = new BigInteger("1");
        for(int i=0; i<b; i++){
            A = A.multiply(new BigInteger(String.valueOf(a-i)));
            B = B.multiply(new BigInteger(String.valueOf(i+1)));
        }
        System.out.println(A.divide(B));
    }
}
