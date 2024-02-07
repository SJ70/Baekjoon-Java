import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _4811 {

    private static final int MAX_N = 30;
    private static long[][] arr = new long[MAX_N + 1][MAX_N + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dp();
        StringBuilder sb = new StringBuilder();
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }
            sb.append(arr[n][n]);
            sb.append('\n');
        }
        System.out.print(sb);
    }

    private static void dp() {
        arr[1][0] = 1;

        for (int w = 0; w <= MAX_N; w++) {
            for (int h = 0; h <= MAX_N; h++) {
                if (w < MAX_N) {
                    arr[w+1][h] += arr[w][h];
                }
                if (h < w) {
                    arr[w][h+1] += arr[w][h];
                }
//                System.out.printf("%8d", arr[w][h]);
            }
//            System.out.println();
        }
    }

}
