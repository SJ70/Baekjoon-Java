import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _3985 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        boolean[] visited = new boolean[L + 1];

        int maxExpectedValue = -1;
        int maxExpectedIdx = -1;
        int maxValue = -1;
        int maxIdx = -1;
        for (int i=1; i<=N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int until = Integer.parseInt(st.nextToken());
            int expectedValue = until - from + 1;
            if (expectedValue > maxExpectedValue) {
                maxExpectedValue = expectedValue;
                maxExpectedIdx = i;
            }
            int value = 0;
            for (int j=from; j<=until; j++) {
                if (!visited[j]) {
                    visited[j] = true;
                    value++;
                }
            }
            if (value > maxValue) {
                maxIdx = i;
                maxValue = value;
            }
        }

        System.out.println(maxExpectedIdx);
        System.out.println(maxIdx);

    }

}
