import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _27966 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        StringBuilder sb = new StringBuilder();

        sb.append((N - 1) * (N - 1));
        sb.append('\n');
        for (int i=2; i<=N; i++) {
            sb.append(1);
            sb.append(' ');
            sb.append(i);
            sb.append('\n');
        }
        System.out.print(sb);
    }

}
