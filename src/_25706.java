import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _25706 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[N];
        for (int i=N-1; i>=0; i--) {
            if (i + arr[i] + 1 < N) {
                dp[i] = dp[i + arr[i] + 1];
            }
            dp[i]++;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(dp[0]);
        for (int i=1; i<N; i++) {
            sb.append(" ");
            sb.append(dp[i]);
        }
        System.out.println(sb);
    }

}
