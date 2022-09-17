import java.math.BigInteger;
import java.util.Scanner;
import java.util.StringTokenizer;

public class _15740 {
    public static void main(String[] args){
        StringTokenizer st = new StringTokenizer(new Scanner(System.in).nextLine());
        BigInteger A = new BigInteger(st.nextToken());
        BigInteger B = new BigInteger(st.nextToken());
        System.out.println(A.add(B));
    }
}