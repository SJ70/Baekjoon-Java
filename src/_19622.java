import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _19622 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            st.nextToken();
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N+3];
        for (int i=0; i<N; i++) {
            int j = i+3;
            dp[j] = Math.max(dp[j-2], dp[j-3]) + arr[i];
        }

        int max = Arrays.stream(dp)
                .max()
                .getAsInt();
        System.out.println(max);
    }

}
