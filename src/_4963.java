import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _4963 {

    private static StringBuilder sb = new StringBuilder();
    private static int R, C;
    private static boolean[][] land;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            C = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            if (R==0 && C==0) {
                break;
            }
            land = new boolean[R][C];
            visited = new boolean[R][C];
            int result = 0;
            for (int r=0; r<R; r++) {
                StringTokenizer input = new StringTokenizer(br.readLine());
                for (int c=0; c<C; c++) {
                    land[r][c] = input.nextToken().equals("1");
                }
            }
            for (int r=0; r<R; r++) {
                for (int c=0; c<C; c++) {
                    if (!visited[r][c] && land[r][c]) {
                        result++;
                        dfs(r, c);
                    }
                }
            }
            sb.append(result);
            sb.append('\n');
        }
        System.out.print(sb);
    }

    private static void dfs(int r, int c) {
        if (r<0 || r>=R || c<0 || c>=C || visited[r][c] || !land[r][c]) {
            return;
        }
        visited[r][c] = true;
        for (int i=r-1; i<=r+1; i++) {
            for (int j=c-1; j<=c+1; j++) {
                dfs(i, j);
            }
        }
    }

}
