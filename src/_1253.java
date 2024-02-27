import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class _1253 {

    private static int N;
    private static int[] arr;
    private static Map<Integer, Integer> numCnt = new HashMap<>();

    public static void main(String[] args) throws IOException {
        init();

        int result = 0;
        for (int i=0; i<N; i++) {
            int target = arr[i];
            int targetCnt = numCnt.getOrDefault(target, 0);
            for (int j=0; j<N; j++) {
                int num1 = arr[j];
                int num2 = arr[i] - arr[j];
                int num2Cnt = numCnt.getOrDefault(num2, 0);

                if (num1 == num2 && num2Cnt < 2) {
                    // m + m = n
                    continue;
                }
                if (num1 == 0 && num2 == 0 && num2Cnt < 3) {
                    // 0 + 0 = 0
                    continue;
                }
                if ((num1 == 0 || num2 == 0) && targetCnt == 1) {
                    // n + 0 = n
                    continue;
                }
                if (num2Cnt >= 1) {
                    result++;
                    break;
                }
            }
        }
        System.out.println(result);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            numCnt.put(arr[i], numCnt.getOrDefault(arr[i] , 0) + 1);
        }
    }

}
