import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _23809 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        for (int i=0; i<N; i++) {
            sb.append("@".repeat(N));
            sb.append("   ".repeat(N));
            sb.append("@".repeat(N));
            sb.append('\n');
        }
        for (int i=0; i<N; i++) {
            sb.append("@".repeat(N));
            sb.append("  ".repeat(N));
            sb.append("@".repeat(N));
            sb.append('\n');
        }
        for (int i=0; i<N; i++) {
            sb.append("@@@".repeat(N));
            sb.append('\n');
        }
        for (int i=0; i<N; i++) {
            sb.append("@".repeat(N));
            sb.append("  ".repeat(N));
            sb.append("@".repeat(N));
            sb.append('\n');
        }
        for (int i=0; i<N; i++) {
            sb.append("@".repeat(N));
            sb.append("   ".repeat(N));
            sb.append("@".repeat(N));
            sb.append('\n');
        }
        System.out.print(sb);


    }

}
