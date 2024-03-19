import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _11561 {

    private static final int MAX_STEP = 150000000;

    public static void main(String[] args) throws IOException {
//        System.out.println(getMinDistPerStep(MAX_STEP));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t=0; t<T; t++) {
            long N = Long.parseLong(br.readLine());
            sb.append(getMaxStep(N, 1, MAX_STEP));
//            System.out.println();
            sb.append('\n');
        }

        System.out.print(sb);

    }

    private static int getMaxStep(long dist, int left, int right) {
        long leftValue = getMinDistPerStep(left);
        long rightValue = getMinDistPerStep(right);
//        System.out.printf("%d (%d) ~ %d (%d)\n", leftValue, left, rightValue, right);
        if (right - left == 1 && leftValue <= dist && rightValue > dist) {
            return left;
        }

        int mid = (left + right) / 2;
        long midValue = getMinDistPerStep(mid);
        if (dist < midValue) {
            return getMaxStep(dist, left, mid);
        }
        if (midValue < dist) {
            return getMaxStep(dist, mid, right);
        }
        return mid;

    }

    private static long getMinDistPerStep(int step) {
        return (long)step * (step + 1) / 2;
    }

}
