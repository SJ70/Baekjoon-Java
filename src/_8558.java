import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _8558 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = 1;
        for (int i=2; i<=N; i++) {
            result *= i;
            result %= 10;
        }
        System.out.println(result);
    }

}
