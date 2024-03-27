import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _30868 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t=0; t<T; t++) {
            int N = Integer.parseInt(br.readLine());
            sb.append("++++ ".repeat(N / 5));
            sb.append("|".repeat(N % 5));
            sb.append('\n');
        }

        System.out.print(sb);
    }

}
