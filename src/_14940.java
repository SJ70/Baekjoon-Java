import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class _14940 {

    private static int R, C;
    private static boolean[][] canGo;
    private static int[][] dist;

    private static Queue<int[]> Q = new ArrayDeque<>();

    private static int[] DR = new int[] {-1, 0, 1, 0};
    private static int[] DC = new int[] {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        canGo = new boolean[R][C];
        for (int r=0; r<R; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c=0; c<C; c++) {
                int value = Integer.parseInt(st.nextToken());
                switch (value) {
                    case 2 :
                        Q.add(new int[]{r, c});
                    case 1 :
                        canGo[r][c] = true;
                }
            }
        }

        dist = new int[R][C];
        for (int r=0; r<R; r++) {
            for (int c=0; c<C; c++) {
                dist[r][c] = canGo[r][c] ? -1 : 0;
            }
        }

        dist[Q.peek()[0]][Q.peek()[1]] = 0;
        canGo[Q.peek()[0]][Q.peek()[1]] = false;

        while (!Q.isEmpty()) {
            int r = Q.peek()[0];
            int c = Q.poll()[1];
            int value = dist[r][c];

            for (int dir=0; dir<4; dir++) {
                int nextR = r + DR[dir];
                int nextC = c + DC[dir];
                if (nextR >= 0 && nextR < R && nextC >= 0 && nextC < C && canGo[nextR][nextC]) {
                    dist[nextR][nextC] = value + 1;
                    Q.add(new int[] {nextR, nextC});
                    canGo[nextR][nextC] = false;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int r=0; r<R; r++) {
            for (int c=0; c<C; c++) {
                sb.append(dist[r][c]);
                sb.append((c == C - 1) ? '\n' : ' ');
            }
        }

        System.out.print(sb);
    }

}
