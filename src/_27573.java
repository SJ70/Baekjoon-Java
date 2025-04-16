import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _27573 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int minSegmentSize = Integer.parseInt(st.nextToken());
        int maxSegmentSize = Integer.parseInt(st.nextToken());

        // 누적 합
        int[] arr = new int[n+1];
        for (int i=1; i<=n; i++) {
            arr[i] = arr[i-1] + Integer.parseInt(br.readLine());
        }

        int minResult = Integer.MAX_VALUE;
        int maxResult = Integer.MIN_VALUE;
        for (int segmentSize = minSegmentSize; segmentSize <= maxSegmentSize; segmentSize++) {
            for (int startIdx = 0; startIdx < segmentSize; startIdx++) {
                int result = 0;
                for (int i=startIdx-segmentSize; i<n; i+=segmentSize) {
                    int from = Math.max(0, i);
                    int until = Math.min(n, i+segmentSize);
//                    System.out.printf("%d %d\n", from, until);
                    int sum = arr[until] - arr[from];
                    if (sum > 0) {
                        result++;
                    }
                }
                minResult = Math.min(result, minResult);
                maxResult = Math.max(result, maxResult);
//                System.out.println();
            }
        }
        System.out.printf("%d %d\n", minResult, maxResult);
    }

}
