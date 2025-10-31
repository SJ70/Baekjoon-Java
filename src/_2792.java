import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2792 {

    private static int N, M;
    private static int[] values;
    private static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        values = new int[M];
        for (int i=0; i<M; i++) {
            values[i] = Integer.parseInt(br.readLine());
        }

        int left = 1;
        int right = Arrays.stream(values).max().getAsInt();
        bs(left, right);

        System.out.println(result);
    }

    private static void bs(int left, int right) {
//        System.out.printf("%d %d\n", left, right);

        int mid = (left + right) / 2;
        if (hasResult(mid)) {
            result = mid;
            if (left == right) {
                return;
            }
            bs(left, mid);
        } else {
            bs(mid + 1, right);
        }
    }

    private static boolean hasResult(int jealous) {
        int n = 0;
        for (int value : values) {
            n += (value + jealous - 1) / jealous;
        }
        return n <= N;
    }

}
