import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _6929 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = - (N - 1); i < N; i+=2) {
            int j = Math.abs(i);
            sb.append("*".repeat(N - j));
            sb.append(" ".repeat(2 * j));
            sb.append("*".repeat(N - j));
            sb.append('\n');
        }
        System.out.print(sb);

    }

}
