import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class _10826 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if (N <= 1) {
            System.out.println(N);
            return;
        }
        BigInteger a = BigInteger.ZERO;
        BigInteger b = BigInteger.ONE;
        for (int i=1; i<N; i++) {
            BigInteger sum = a.add(b);
            a = b;
            b = sum;
        }
        System.out.println(b);
    }

}
