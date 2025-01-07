import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _32964 {

    private static int N;
    private static char[][] pipes;
    private static boolean canGoUp, canGoDown;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        pipes = new char[N][2];

        for (int r=0; r<2; r++) {
            String input = br.readLine();
            for (int c=0; c<N; c++) {
                pipes[c][r] = input.charAt(c);
            }
        }

        canGoUp = true;
        canGoDown = (pipes[0][1] == 'L');
        for (int i=1; i<N-1; i++) {
            boolean canGoUpNext = false;
            boolean canGoDownNext = false;
            if (canGoUp) {
                if (pipes[i][0] == 'I'){
                    canGoUpNext = true;
                }
                if (pipes[i][0] == 'L' && pipes[i][1] == 'L') {
                    canGoDownNext = true;
                }
            }
            if (canGoDown) {
                if (pipes[i][1] == 'I'){
                    canGoDownNext = true;
                }
                if (pipes[i][0] == 'L' && pipes[i][1] == 'L') {
                    canGoUpNext = true;
                }
            }
            canGoUp = canGoUpNext;
            canGoDown = canGoDownNext;
        }

        boolean result = (canGoUp && pipes[N-1][0] == 'L' || canGoDown);
        System.out.println(result ? "YES" : "NO");
    }

}
