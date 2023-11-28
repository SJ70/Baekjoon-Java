import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _3980 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();

    private static final int N = 11;
    private static int[][] values;
    private static boolean[] visited;

    private static int maxResult;

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        for (int i=0; i<t; i++) {
            init();
            bt(0, 0);
            sb.append(maxResult).append('\n');
        }
        System.out.print(sb);
    }

    private static void init() throws IOException {
        values = new int[N][N];
        visited = new boolean[N];
        maxResult = Integer.MIN_VALUE;

        for (int r=0; r<N; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c=0; c<N; c++) {
                values[r][c] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void bt(int r, int result) {
        if (r==N) {
            maxResult = Math.max(maxResult, result);
            return;
        }
        for (int c=0; c<N; c++) {
            if (visited[c] || values[r][c]==0) {
                continue;
            }
            visited[c] = true;
            bt(r+1, result + values[r][c]);
            visited[c] = false;
        }
    }

}
