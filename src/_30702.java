import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _30702 {

    private static int R;
    private static int C;

    private static char[][] A;
    private static char[][] B;

    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        input();
        try {
            solve();
            System.out.println("YES");
        } catch (IllegalArgumentException e) {
            System.out.println("NO");
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        A = new char[R][C];
        B = new char[R][C];
        for (int r=0; r<R; r++) {
            A[r] = br.readLine().toCharArray();
        }
        for (int r=0; r<R; r++) {
            B[r] = br.readLine().toCharArray();
        }
        visited = new boolean[R][C];
    }

    private static void solve() {
        for (int r=0; r<R; r++) {
            for (int c=0; c<C; c++) {
                if (visited[r][c]) {
                    continue;
                }
                dfs(A[r][c], B[r][c], r, c);
            }
        }
    }

    private static int[] DR = {-1,0,1,0};
    private static int[] DC = {0,-1,0,1};
    private static void dfs(char aValue, char bValue, int r, int c) {
        if (B[r][c] != bValue) {
            throw new IllegalArgumentException();
        }
        visited[r][c] = true;

        for (int dir=0; dir<4; dir++) {
            int nextR = r + DR[dir];
            int nextC = c + DC[dir];

            if (nextR < 0 || nextR == R || nextC < 0 || nextC == C) {
                continue;
            }
            if (visited[nextR][nextC]) {
                continue;
            }
            if (A[nextR][nextC] != aValue) {
                continue;
            }
            dfs(aValue, bValue, nextR, nextC);
        }
    }

}
