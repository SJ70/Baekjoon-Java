import java.math.BigInteger;
import java.util.Scanner;

public class _1271 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        BigInteger A = new BigInteger(String.valueOf(sc.next())) ;
        BigInteger B = new BigInteger(String.valueOf(sc.next())) ;
        System.out.println(A.divide(B)+"\n"+A.mod(B));
    }
}
