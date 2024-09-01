import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _10752 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        char[][] map = new char[R][C];
        for (int r=0; r<R; r++) {
            String input = br.readLine();
            for (int c=0; c<C; c++) {
                map[r][c] = input.charAt(c);
            }
        }

        int[][] dp = new int[R][C];
        dp[0][0] = 1;
        for (int r0=0; r0<R; r0++) {
            for (int c0=0; c0<C; c0++) {
                char currValue = map[r0][c0];
                for (int r1=r0+1; r1<R; r1++) {
                    for (int c1=c0+1; c1<C; c1++) {
                        char nextValue = map[r1][c1];
                        if (currValue != nextValue) {
                            dp[r1][c1] += dp[r0][c0];
                        }
                    }
                }
            }
        }

        System.out.println(dp[R-1][C-1]);

    }

}
