import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class _8437 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger Apple = new BigInteger(br.readLine());
        BigInteger Diff = new BigInteger(br.readLine());
        BigInteger A = Apple.subtract(Diff).divide(new BigInteger("2"));
        BigInteger B = Apple.subtract(A);
        System.out.printf("%d\n%d",B,A);
    }
}
