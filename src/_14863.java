import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14863 {

    private static int N, K;
    private static int[][][] paths;

    private static Integer[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        paths = new int[N+1][2][2];

        for (int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int p=0; p<2; p++) {
                for (int j=0; j<2; j++) {
                    paths[i][p][j] = Integer.parseInt(st.nextToken());
                }
            }
        }

        dp = new Integer[N+1][K+1];
        dp[0][0] = 0;
        for (int n=1; n<=N; n++) {

            for (int k=0; k<=K; k++) {
                if (dp[n-1][k] == null) {
                    continue;
                }

                for (int p=0; p<2; p++) {
                    int t = paths[n][p][0];
                    int m = paths[n][p][1];
                    if (k+t <= K) {
                        if (dp[n][k+t] == null || dp[n][k+t] < dp[n-1][k] + m) {
                            dp[n][k+t] = dp[n-1][k] + m;
                        }
                    }
                }

            }
        }

        int result = 0;
        for (int k=0; k<=K; k++) {
            if (dp[N][k] != null) {
                result = Math.max(result, dp[N][k]);
            }
        }

        System.out.println(result);
    }

}
