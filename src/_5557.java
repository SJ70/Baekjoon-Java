import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class _5557 {

    private static int N;
    private static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Map<Long, Long> sums = new HashMap<>();
        sums.put(arr[0], 1L);
//        System.out.println(sums);
        for (int i=1; i<N-1; i++) {
            Map<Long, Long> next = new HashMap<>();
            for (Entry<Long, Long> e : sums.entrySet()) {
                long value1 = e.getKey() + arr[i];
                if (value1 >= 0 && value1 <= 20) {
                    next.put(value1, next.getOrDefault(value1, 0L) + e.getValue());
                }
                long value2 = e.getKey() - arr[i];
                if (value2 >= 0 && value2 <= 20) {
                    next.put(value2, next.getOrDefault(value2, 0L) + e.getValue());
                }
            }
            sums = next;
//            System.out.println(sums);
        }

        System.out.println(sums.getOrDefault(arr[N-1], 0L));

    }

}
