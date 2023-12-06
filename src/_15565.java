import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _15565 {

    private static int N, K;
    private static int[] arr;
    private static int[] prefixSum;
    private static int minResult = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        input();
        doPrefixSum();
        slidingWindow();
        printResult();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .map(value -> value % 2)
                .toArray();
    }

    private static void doPrefixSum() {
        prefixSum = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            prefixSum[i] = arr[i - 1] + prefixSum[i - 1];
        }
    }

    private static void slidingWindow() {
        int left = 1;
        int right = 1;
        while (left <= right && right <= N) {
            int targetCount = prefixSum[right] - prefixSum[left - 1] ;
            if (targetCount == K) {
                minResult = Math.min(minResult, right - left + 1);
                left++;
            }
            else {
                right++;
            }
        }
    }

    private static void printResult() {
        System.out.println(minResult == Integer.MAX_VALUE ? -1 : minResult);
    }

}
