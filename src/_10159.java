import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10159 {

    private static int n;
    private static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        int m = Integer.parseInt(br.readLine());
        for (int i=0; i<m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            arr[a][b] = 1;
            arr[b][a] = -1;
        }

        for (int across = 0; across < n; across++) {
            for (int from = 0; from < n; from++) {
                if (arr[from][across] == 0) {
                    continue;
                }
                for (int to = 0; to < n; to++) {
                    if (arr[from][across] == arr[across][to]) {
                        arr[from][to] = arr[from][across];
                        arr[to][from] = arr[across][from];
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<n; i++) {
            int cnt = 0;
            for (int j=0; j<n; j++) {
                if (i == j) {
                    continue;
                }
                if (arr[i][j] == 0) {
                    cnt++;
                }
            }
            sb.append(cnt);
            sb.append('\n');
        }
        System.out.print(sb);

    }

}
