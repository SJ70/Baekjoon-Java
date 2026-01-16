import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _32334 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][N];
        for (int i=0; i<N; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int[][] prefixSum = new int[N+1][N+1];
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                prefixSum[i+1][j+1] = arr[i][j];
            }
        }
        for (int i=1; i<=N; i++) {
            for (int j=1; j<=N; j++) {
                prefixSum[i][j] += prefixSum[i][j-1];
            }
        }
        for (int i=1; i<=N; i++) {
            for (int j=1; j<=N; j++) {
                prefixSum[i][j] += prefixSum[i-1][j];
            }
        }

//        for (int i=1; i<=N; i++) {
//            for (int j=1; j<=N; j++) {
//                System.out.print(prefixSum[i][j] + " ");
//            }
//            System.out.println();
//        }

        int minCnt = Integer.MAX_VALUE;
        int minR = 0;
        int minC = 0;
        for (int i=1; i<=N; i++) {
            for (int j=1; j<=N; j++) {
                if (arr[i-1][j-1] == 1) {
                    continue;
                }
                int i1 = Math.max(0, i-D-1);
                int i2 = Math.min(N, i+D);
                int j1 = Math.max(0, j-D-1);
                int j2 = Math.min(N, j+D);
                int cnt = prefixSum[i2][j2]
                        - prefixSum[i2][j1]
                        - prefixSum[i1][j2]
                        + prefixSum[i1][j1];
//                System.out.printf("%d %d ~ %d %d, %d\n", i1, j1, i2, j2, cnt);
                if (cnt < minCnt) {
                    minR = i;
                    minC = j;
                    minCnt = cnt;
                }
            }
        }
        System.out.printf("%d %d\n", minR, minC);
        if (minCnt > 0) {
            System.out.println(minCnt);
        }

    }

}
