import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1743 {

    private static int R, C, N;
    private static boolean[][] isTrash;
    private static boolean[][] isVisited;
    private static int currentCnt;
    private static int maxCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        isTrash = new boolean[R][C];
        isVisited = new boolean[R][C];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            isTrash[r][c] = true;
        }
        for (int r=0; r<R; r++) {
            for (int c=0; c<C; c++) {
                if (isTrash[r][c] && !isVisited[r][c]) {
                    currentCnt = 0;
                    bfs(r, c);
                }
                maxCnt = Math.max(currentCnt, maxCnt);
            }
        }
        System.out.println(maxCnt);
    }

    private static void bfs(int r, int c) {
        if (r < 0 || r >= R || c < 0 || c >= C) {
            return;
        }
        if (!isTrash[r][c] || isVisited[r][c]) {
            return;
        }
        isVisited[r][c] = true;
        currentCnt++;
        bfs(r+1, c);
        bfs(r-1, c);
        bfs(r, c-1);
        bfs(r, c+1);
    }

}
