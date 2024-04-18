import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class _31575 {

    private static int R, C;
    private static boolean[][] canGo;
    private static Queue<int[]> Q;

    private static final int[] DR = new int[] {1, 0};
    private static final int[] DC = new int[] {0, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        canGo = new boolean[R][C];
        for (int r=0; r<R; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c=0; c<C; c++) {
                canGo[r][c] = st.nextToken().equals("1");
            }
        }

        Q = new ArrayDeque<>();
        Q.add(new int[] {0, 0});
        canGo[0][0] = false;

        while(!Q.isEmpty()) {
            int r = Q.peek()[0];
            int c = Q.poll()[1];
            if (r == R-1 && c == C-1) {
                System.out.println("Yes");
                return;
            }

            for (int dir = 0; dir < 2; dir++) {
                int nextR = r + DR[dir];
                int nextC = c + DC[dir];
                if (nextR >= 0 && nextR < R && nextC >= 0 && nextC < C && canGo[nextR][nextC]) {
                    canGo[nextR][nextC] = false;
                    Q.add(new int[] {nextR, nextC});
                }
            }

        }

        System.out.println("No");

    }

}
