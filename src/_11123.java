import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11123 {

    private static int R, C;
    private static boolean[][] visited;
    private static int result;
    private static char[][] arr;
    private static int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int T = Integer.parseInt(br.readLine());
        for (int t=0; t<T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            arr = new char[R][C];
            for (int r=0; r<R; r++) {
                arr[r] = br.readLine().toCharArray();
            }
            visited = new boolean[R][C];
            result = 0;
            for (int r=0; r<R; r++) {
                for (int c=0; c<C; c++) {
                    if (visited[r][c] || arr[r][c] == '.') {
                        continue;
                    }
                    result++;
                    visit(r, c);
                }
            }
            sb.append(result);
            sb.append('\n');
        }
        System.out.print(sb);
    }

    private static void visit(int r, int c) {
        if (r < 0 || r >= R || c < 0 || c >= C) {
            return;
        }
        if (visited[r][c] || arr[r][c] == '.') {
            return;
        }
        visited[r][c] = true;
        for (int[] dir : dirs) {
            visit(r + dir[0], c + dir[1]);
        }
    }

}
