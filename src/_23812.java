import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _23812 {

    private static int N;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        drawFallAway();;
        drawLine();
        drawFallAway();
        drawLine();
        drawFallAway();
        System.out.print(sb);

    }

    private static void drawFallAway() {
        for (int i=0; i<N; i++) {
            sb.append("@".repeat(N));
            sb.append("   ".repeat(N));
            sb.append("@".repeat(N));
            sb.append('\n');
        }
    }

    private static void drawLine() {
        for (int i=0; i<N; i++) {
            sb.append("@@@@@".repeat(N));
            sb.append('\n');
        }
    }

}
