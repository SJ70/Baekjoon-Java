import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1654 {

    private static long[] lengths;
    private static long requiredCnt;

    public static void main(String[] args) throws IOException {

        input();

        long left = 1;
        long right = (long)Integer.MAX_VALUE + 1;
        long mid = 0;
        while (left < right) {

//            System.out.printf("%d %d\n",left,right);

            mid = (left + right) / 2;
            long cnt = getCnt(mid);

            if (cnt < requiredCnt) {
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }
        System.out.println(left - 1);

    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        requiredCnt = Long.parseLong(st.nextToken());
        lengths = new long[n];
        for (int i=0; i<n; i++) {
            lengths[i] = Long.parseLong(br.readLine());
        }
    }

    private static long getCnt(long divider) {
        int result = 0;
        for (long length : lengths) {
            result += length / divider;
        }
        return result;
    }

}
