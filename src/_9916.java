import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class _9916 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        BigInteger value = new BigInteger("1");
        for (int i=2; i<=N; i++) {
            value = value.multiply(new BigInteger(String.valueOf(i)));
        }

        int result = 0;
        for (char c : value.toString().toCharArray()) {
            if (c == '0') {
                result++;
            }
        }
        System.out.println(result);
    }

}
