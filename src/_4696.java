import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _4696 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            double N = Double.parseDouble(br.readLine());
            if (N == 0) {
                break;
            }
            double result = 1;
            result += N;
            result += N * N;
            result += N * N * N;
            result += N * N * N * N;
            sb.append(String.format("%.2f\n", result));
        }
        System.out.print(sb);
    }

}
