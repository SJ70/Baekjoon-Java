import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _27648 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int max = Integer.parseInt(st.nextToken());
        int[][] arr = new int[R][C];
        for (int r=0; r<R; r++) {
            for (int c=0; c<C; c++) {
                int left = (c == 0) ? 0 : arr[r][c-1];
                int up = (r == 0) ? 0 : arr[r-1][c];
                arr[r][c] = Math.max(left, up) + 1;
            }
        }
        if (arr[R-1][C-1] <= max) {
            arr[R-1][C-1] = max;
            StringBuilder sb = new StringBuilder();
            sb.append("YES\n");
            for (int r=0; r<R; r++) {
                for (int c=0; c<C; c++) {
                    sb.append(arr[r][c]);
                    sb.append((c == C-1) ? '\n' : ' ');
                }
            }
            System.out.print(sb);
        }
        else {
            System.out.println("NO");
        }
    }

}
