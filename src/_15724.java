import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _15724 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[][] arr = new int[R+1][C+1];
        for (int r=0; r<R; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c=0; c<C; c++) {
                arr[r+1][c+1] = Integer.parseInt(st.nextToken());
            }
        }
        for (int r=1; r<=R; r++) {
            for (int c=1; c<=C; c++) {
                arr[r][c] += arr[r][c-1];
            }
        }
        for (int r=1; r<=R; r++) {
            for (int c=1; c<=C; c++) {
                arr[r][c] += arr[r-1][c];
            }
        }

        StringBuilder sb = new StringBuilder();
        int K = Integer.parseInt(br.readLine());
        for (int k=0; k<K; k++) {
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken()) - 1;
            int c1 = Integer.parseInt(st.nextToken()) - 1;
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());
            int result = arr[r2][c2] - arr[r1][c2] - arr[r2][c1] + arr[r1][c1];
            sb.append(result).append('\n');
        }
        System.out.print(sb);
    }

}
