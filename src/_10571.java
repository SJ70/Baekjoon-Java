import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10571 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t=0; t<T; t++) {
            int N = Integer.parseInt(br.readLine());
            double[][] jewel = new double[N][2];
            for (int i=0; i<N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                jewel[i][0] = Double.parseDouble(st.nextToken());
                jewel[i][1] = Double.parseDouble(st.nextToken());
            }

            int maxResult = 1;
            int[] dp = new int[N + 1];
            for (int i=0; i<N; i++) {
                dp[i] = 1;
                for (int j=i-1; j>=0; j--) {
                    if (dp[i] < dp[j] + 1 && jewel[i][0] > jewel[j][0] && jewel[i][1] < jewel[j][1]) {
                        dp[i] = dp[j] + 1;
                        maxResult = Math.max(maxResult, dp[i]);
                    }
                }
            }
            sb.append(maxResult);
            sb.append('\n');
        }
        System.out.print(sb);
    }

}
