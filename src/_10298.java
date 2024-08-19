import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10298 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t=0; t<T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            int moveCnt = Integer.parseInt(st.nextToken());
            int divider = Integer.parseInt(st.nextToken());
            long[][][] arr = new long[moveCnt][R][C];

            for (int r=0; r<R; r++) {
                for (int c=0; c<C; c++) {
                    arr[0][r][c] = 1 % divider;
                }
            }

            for (int i=1; i<moveCnt; i++) {
                for (int r=0; r<R; r++) {
                    for (int c=0; c<C; c++) {
                        arr[i][r][c] = arr[i-1][r][c];
                        if (r-1 >= 0) {
                            arr[i][r][c] += arr[i-1][r-1][c];
                        }
                        if (r+1 < R) {
                            arr[i][r][c] += arr[i-1][r+1][c];
                        }
                        if (c-1 >= 0) {
                            arr[i][r][c] += arr[i-1][r][c-1];
                        }
                        if (c+1 < C) {
                            arr[i][r][c] += arr[i-1][r][c+1];
                        }
                        arr[i][r][c] %= divider;
                    }
                }
            }

            long result = 0;
            for (int r=0; r<R; r++) {
                for (int c=0; c<C; c++) {
                    result += arr[moveCnt-1][r][c];
                }
            }
            result %= divider;
            sb.append(result).append('\n');
        }

        System.out.print(sb);

    }

}
