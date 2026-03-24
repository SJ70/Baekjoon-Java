import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1988 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[][][] dp = new int[N][M][2];
        for (int i=1; i<N; i++) {
            for (int j=1; j<M; j++) {
                dp[i][j][0] = Math.max(
                        dp[i-1][j][0],
                        dp[i-1][j][1]
                );
                dp[i][j][1] = Math.max(
                        dp[i-1][j-1][0],
                        dp[i-1][j-1][1] + arr[i]
                );
            }
        }
//        for (int i=0; i<N; i++) {
//            for (int j=0; j<M; j++) {
//                System.out.printf("    %4d %4d", dp[i][j][0], dp[i][j][1]);
//            }
//            System.out.println();
//        }

        int result = 0;
        for (int i=0; i<N; i++) {
            for (int k=0; k<=1; k++) {
                result = Math.max(result, dp[i][M-1][k]);
            }
        }
        System.out.println(result);
    }

}
