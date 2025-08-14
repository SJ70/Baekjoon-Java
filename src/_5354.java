import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _5354 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i=0; i<T; i++) {
            int N = Integer.parseInt(br.readLine());
            sb.append("#".repeat(N)).append('\n');
            if (N > 1) {
                sb.append(("#" + "J".repeat(N-2) + "#\n").repeat(N-2));
                sb.append("#".repeat(N)).append('\n');
            }
            if (i < T-1) {
                sb.append('\n');
            }
        }
        System.out.print(sb);
    }

}
