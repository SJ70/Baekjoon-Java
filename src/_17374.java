import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _17374 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t=0; t<T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int bit = Integer.parseInt(st.nextToken());
            int berry = Integer.parseInt(st.nextToken());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());

            int coin = berry / C * D;

            int result = Math.min(bit, coin);
            bit -= result;
            coin -= result;

            if (bit > 0) {
                result += (int) calcMaxBonus(0, 100000000, bit, A, B);
            }
            else {
                result += (int) calcMaxBonus(0, 100000000, coin, B, A);
            }

            sb.append(result);
            sb.append('\n');

        }
        System.out.print(sb);
    }

    private static long calcMaxBonus(long left, long right, long from, long input, long output) {
        long mid = (left + right) / 2;
        if (left >= right) {
            return Math.min(from - input * mid, output * mid);
        }

        if (from < input * mid) {
            return calcMaxBonus(left, mid-1, from, input, output);
        }
        else {
            long midBonus = Math.min(from - input * mid, output * mid);
            long leftBonus = mid > 0
                    ? Math.min(from - input * (mid-1), output * (mid-1))
                    : midBonus;
            long rightBonus = from > input * (mid+1)
                    ? Math.min(from - input * (mid+1), output * (mid+1))
                    : midBonus;
            if (leftBonus > midBonus) {
                return calcMaxBonus(left, mid-1, from, input, output);
            }
            else if (rightBonus > midBonus) {
                return calcMaxBonus(mid+1, right, from, input, output);
            }
            else {
                return midBonus;
            }
        }
    }

}
