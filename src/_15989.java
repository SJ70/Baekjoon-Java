import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _15989 {

    private static final int N = 10000;

    public static void main(String[] args) throws IOException {

        long[] arr = new long[N + 1];
        arr[0] = 1;

        for (int add=1; add<=3; add++) {
            for (int i=1; i<=N; i++) {
                if (i - add >= 0) {
                    arr[i] += arr[i - add];
                }
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t=0; t<T; t++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(arr[n]);
            sb.append('\n');
        }

        System.out.print(sb);

    }

}
