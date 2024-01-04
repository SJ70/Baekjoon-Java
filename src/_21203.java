import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class _21203 {

    private static int n;
    private static final List<Long> streetNums = new ArrayList<>();
    private static final List<Long> distances = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        input();
        long result = getDiffs(streetNums) + getDiffs(distances);
        System.out.println(result);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long s = Long.parseLong(st.nextToken());
            long a = Long.parseLong(st.nextToken());
            streetNums.add(s);
            distances.add(a);
        }
        Collections.sort(streetNums);
        Collections.sort(distances);
    }

    private static long getDiffs(List<Long> arr) {
        long result = 0L;
        for (int i=0; i<n; i++) {
            Long value = arr.get(i);
            long mul = 2 * (long) i - n + 1; // - (n - 1 - i) + i
            result += value * mul;
        }
        return result;
    }
}
