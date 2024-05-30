import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _16988 {

    private static int R, C;
    private static int[][] arr;
    private static boolean[][] put;
    private static boolean[][] visited;
    private static int maxCnt = 0;

    public static void main(String[] args) throws IOException {
        input();

        put = new boolean[R][C];
        for (int i=0; i<R*C; i++) {
            int r1 = i/C;
            int c1 = i%C;
            if (!isEmpty(r1, c1)) {
                continue;
            }
            put[r1][c1] = true;
            for (int j=i+1; j<R*C; j++) {
                int r2 = j/C;
                int c2 = j%C;
                if (!isEmpty(r2, c2)) {
                    continue;
                }
                put[r2][c2] = true;

                simulate();

                put[r2][c2] = false;
            }
            put[r1][c1] = false;
        }

        System.out.println(maxCnt);

    }

    private static void input() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new int[R][C];
        for (int r=0; r<R; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c=0; c<C; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

    }

    private static boolean hasHole;
    private static void simulate() {
        int entireCnt = 0;
        visited = new boolean[R][C];
        for (int r=0; r<R; r++) {
            for (int c=0; c<C; c++) {
                hasHole = false;
                if (!visited[r][c] && isEnemy(r, c)) {
                    int tmp = dfs(r, c);
                    if (!hasHole) {
                        entireCnt += tmp;
                    }
                }
            }
        }
        maxCnt = Math.max(entireCnt, maxCnt);
    }

    private static int dfs(int r, int c) {
        if (isOutside(r, c) || visited[r][c]) {
            return 0;
        }
        if (isEmpty(r, c)) {
            hasHole = true;
            return 0;
        }
        if (isAlley(r, c)) {
            return 0;
        }
        if (isEnemy(r, c)) {
            visited[r][c] = true;
            return 1 + dfs(r-1, c) + dfs(r+1, c) + dfs(r, c-1) + dfs(r, c+1);
        }
        return 0;
    }

    private static boolean isOutside(int r, int c) {
        return r<0 || r>=R || c<0 || c>=C;
    }

    private static boolean isEmpty(int r, int c) {
        return arr[r][c] == 0 && !put[r][c];
    }

    private static boolean isAlley(int r, int c) {
        return arr[r][c] == 1 || put[r][c];
    }

    private static boolean isEnemy(int r, int c) {
        return arr[r][c] == 2;
    }

}
