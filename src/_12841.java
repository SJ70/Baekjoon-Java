import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _12841 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        long[] cross = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            cross[i] = Long.parseLong(st.nextToken());
        }

        long[] left = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i=1; i<N; i++) {
            left[i] = Long.parseLong(st.nextToken()) + left[i-1];
        }

        long[] right = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N-1; i++) {
            right[i] = Long.parseLong(st.nextToken());
        }
        for (int i=N-2; i>=0; i--) {
            right[i] += right[i+1];
        }

        int minResultIdx = -1;
        long minResult = Long.MAX_VALUE;
        for (int i=0; i<N; i++) {
            long result = cross[i] + left[i] + right[i];
            if (result < minResult) {
                minResult = result;
                minResultIdx = i;
            }
        }

        System.out.printf("%d %d\n", minResultIdx + 1, minResult);
    }

}
