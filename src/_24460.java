import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _24460 {

    private static int N;
    private static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        if (N == 1) {
            System.out.println(br.readLine());
            return;
        }
        arr = new int[N][N];
        for (int r=0; r<N; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c=0; c<N; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int result = fn(0, 0, N);
        System.out.println(result);
    }

    private static int fn(int r, int c, int n) {
        int m = n/2;
        int[] values = new int[4];
        values[0] = (n == 2) ? arr[r][c] : fn(r, c, m);
        values[1] = (n == 2) ? arr[r+1][c] : fn(r + m, c, m);
        values[2] = (n == 2) ? arr[r][c+1] : fn(r, c + m, m);
        values[3] = (n == 2) ? arr[r+1][c+1] : fn(r + m, c + m, m);
        Arrays.sort(values);
        return values[1];
    }

}
