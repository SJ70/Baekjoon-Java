import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _8340 {

    private static int N;
    private static int[][] arr;
    private static List<Integer>[] connected;
    private static int groupCnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[2][N];
        for (int r=0; r<2; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c=0; c<N; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken()) - 1;
            }
        }

        connected = new List[N];
        for (int i=0; i<N; i++) {
            connected[i] = new ArrayList<>();
        }
        for (int i=0; i<N; i++) {
            int u = arr[0][i];
            int d = arr[1][i];
            connected[u].add(d);
            connected[d].add(u);
        }

        boolean[] visited = new boolean[N];
        for (int i=0; i<N; i++) {
            if (!visited[i]) {
                groupCnt++;
                visited[i] = true;
                dfs(i, visited);
            }
        }

        long result = (long) Math.pow(2, groupCnt);
        System.out.println(result);
    }

    private static void dfs(int i, boolean[] visited) {
        for (int j : connected[i]) {
            if (!visited[j]) {
                visited[j] = true;
                dfs(j, visited);
            }
        }
    }

}
