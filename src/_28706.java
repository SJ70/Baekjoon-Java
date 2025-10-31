import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _28706 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t=0; t<T; t++) {
            int N = Integer.parseInt(br.readLine());
            boolean[][] dp = new boolean[N+1][7];
            dp[0][1] = true;
            for (int i=0; i<N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j=0; j<2; j++) {
                    char operator = st.nextToken().charAt(0);
                    int value = Integer.parseInt(st.nextToken());
                    for (int k=0; k<=6; k++) {
                        if (dp[i][k]) {
                            switch (operator) {
                                case '+' : dp[i+1][(k+value)%7] = true; break;
                                case '*' : dp[i+1][(k*value)%7] = true; break;
                            }
                        }
                    }
                }
            }
            sb.append(dp[N][0] ? "LUCKY" : "UNLUCKY");
            sb.append('\n');
        }
        System.out.print(sb);
    }

}
