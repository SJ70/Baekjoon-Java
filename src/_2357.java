import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2357 {

    private static int N;
    private static int Q;
    private static int arrLength;
    private static int[] min;
    private static int[] max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        arrLength = 1;
        while (arrLength < N) {
            arrLength *= 2;
        }
        arrLength *= 2;
        min = new int[arrLength];
        max = new int[arrLength];

        for (int i=arrLength/2; i<arrLength/2+N; i++) {
            min[i] = max[i] = Integer.parseInt(br.readLine());
        }
        for (int i=arrLength/2-1; i>=1; i--) {
            min[i] = Math.min(min[i*2], min[i*2+1]);
            max[i] = Math.max(max[i*2], max[i*2+1]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<Q; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int until = Integer.parseInt(st.nextToken()) - 1;
            sb.append(getMin(1, from, until, 0, arrLength/2-1));
            sb.append(' ');
            sb.append(getMax(1, from, until, 0, arrLength/2-1));
            sb.append('\n');
        }
        System.out.print(sb);
    }

    private static int getMin(int idx, int from, int until, int currentFrom, int currentUntil) {
        if (from <= currentFrom && currentUntil <= until) {
            return min[idx];
        }
        if (currentUntil < from || until < currentFrom) {
            return Integer.MAX_VALUE;
        }
        int currentMid = (currentFrom + currentUntil) / 2;
        int left = getMin(idx*2, from, until, currentFrom, currentMid);
        int right = getMin(idx*2+1, from, until, currentMid+1, currentUntil);
        return Math.min(left, right);
    }

    private static int getMax(int idx, int from, int until, int currentFrom, int currentUntil) {
        if (from <= currentFrom && currentUntil <= until) {
            return max[idx];
        }
        if (currentUntil < from || until < currentFrom) {
            return Integer.MIN_VALUE;
        }
        int currentMid = (currentFrom + currentUntil) / 2;
        int left = getMax(idx*2, from, until, currentFrom, currentMid);
        int right = getMax(idx*2+1, from, until, currentMid+1, currentUntil);
        return Math.max(left, right);
    }

}
