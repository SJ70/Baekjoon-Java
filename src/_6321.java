import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _6321 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i=1; i<=N; i++) {
            sb.append("String #");
            sb.append(i);
            sb.append('\n');
            for (char c : br.readLine().toCharArray()) {
                if (c == 'Z') {
                    sb.append('A');
                }
                else {
                    sb.append((char)(c + 1));
                }
            }
            sb.append("\n");
            if (i < N) {
                sb.append('\n');
            }
        }
        System.out.print(sb);
    }

}
