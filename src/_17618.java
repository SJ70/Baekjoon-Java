import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _17618 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = 1;
        for (int i=2; i<=N; i++) {
            int value = i;
            int sum = 0;
            while (value > 0) {
                sum += value % 10;
                value /= 10;
            }
            if (i % sum == 0) {
                result++;
            }
        }
        System.out.println(result);
    }
}
