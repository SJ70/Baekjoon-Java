import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _27797 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t=1; t<=T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][N];
            for (int r=0; r<N; r++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int c=0; c<N; c++) {
                    arr[r][c] = Integer.parseInt(st.nextToken());
                }
            }

            int A = 0;
            for (int i=0; i<N; i++) {
                A += arr[i][i];
            }

            int B = 0;
            for (int r=0; r<N; r++) {
                int[] visited = new int[200];
                for (int c=0; c<N; c++) {
                    visited[arr[r][c]]++;
                    if (visited[arr[r][c]] == 2) {
                        B++;
                        break;
                    }
                }
            }

            int C = 0;
            for (int c=0; c<N; c++) {
                int[] visited = new int[200];
                for (int r=0; r<N; r++) {
                    visited[arr[r][c]]++;
                    if (visited[arr[r][c]] == 2) {
                        C++;
                        break;
                    }
                }
            }

            sb.append(String.format("Case #%d: %d %d %d\n", t, A, B, C));
        }
        System.out.print(sb);
    }

}
