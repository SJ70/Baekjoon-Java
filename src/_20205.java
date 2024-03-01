import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _20205 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][N];
        for (int r=0; r<N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c=0; c<N; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int r=0; r<N*K; r++) {
            for (int c=0; c<N*K; c++) {
                sb.append(arr[r / K][c / K]);
                if (c < N*K - 1) {
                    sb.append(' ');
                }
            }
            if (r < N*K - 1) {
                sb.append('\n');
            }
        }
        System.out.print(sb);

    }

}
