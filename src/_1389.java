import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1389 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][N];
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        for (int across=0; across<N; across++) {
            for (int from=0; from<N; from++) {
                if (from == across) {
                    continue;
                }
                for (int to=0; to<N; to++) {
                    if (from == to || to == across) {
                        continue;
                    }
                    int fa = arr[from][across];
                    int at = arr[across][to];
                    if (fa == 0 || at == 0) {
                        continue;
                    }
                    if (arr[from][to] == 0 || arr[from][to] > fa + at) {
                        arr[from][to] = fa + at;
                    }
                }
            }
        }

        int minIdx = 0;
        int minSum = Integer.MAX_VALUE;
        for (int i=0; i<N; i++) {
            int sum = 0;
            for (int j=0; j<N; j++) {
                sum += arr[i][j];
            }
            if (minSum > sum) {
                minSum = sum;
                minIdx = i;
            }
        }
        System.out.println(minIdx + 1);

    }

}
