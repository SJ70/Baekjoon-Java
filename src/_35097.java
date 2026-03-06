import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _35097 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }
            int rowSum = 0;
            for (int i=1; i<=N; i++) {
                rowSum += i;
            }
            int entireSum = 0;
            for (int i=1; i<=N; i++) {
                entireSum += rowSum * i;
            }
            System.out.println(entireSum);
        }
    }

}
