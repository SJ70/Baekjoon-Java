import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2858 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int red = Integer.parseInt(st.nextToken());
        int brown = Integer.parseInt(st.nextToken());
        for (int r = brown; r > 0; r--) {
            if (brown % r != 0) {
                continue;
            }
            int c = brown / r;
            int expectedRed = 2 * r + 2 * c + 4;
            if (red == expectedRed) {
                System.out.printf("%d %d\n", r + 2, c + 2);
                return;
            }
        }
    }

}
