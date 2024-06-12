import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14716 {

    private static int R, C;
    private static boolean[][] isFilled;
    private static boolean[][] visited;
    private static int sectionCnt = 0;

    public static void main(String[] args) throws IOException {

        input();

        visited = new boolean[R][C];
        for (int r=0; r<R; r++) {
            for (int c=0; c<C; c++) {
                if (visited[r][c] || !isFilled[r][c]) {
                    continue;
                }
                sectionCnt++;
                dfs(r, c);
            }
        }

        System.out.println(sectionCnt);

    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        isFilled = new boolean[R][C];
        for (int r=0; r<R; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c=0; c<C; c++) {
                isFilled[r][c] = st.nextToken().charAt(0) == '1';
            }
        }
    }

    private static void dfs(int r, int c) {
        if (r < 0 || r >= R || c < 0 || c >= C || !isFilled[r][c] || visited[r][c]) {
            return;
        }

        visited[r][c] = true;

        dfs(r-1, c-1);
        dfs(r-1, c);
        dfs(r-1, c+1);

        dfs(r+1, c-1);
        dfs(r+1, c);
        dfs(r+1, c+1);

        dfs(r, c-1);
        dfs(r, c+1);
    }

}
