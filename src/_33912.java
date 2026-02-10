import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _33912 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken()) - 1;

        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .map(v -> v - 1)
                .toArray();

        int i;

        long cw = 0;
        i = 0;
        while (i != M) {
            if (arr[i] < cw % N) {
                cw += N;
            }
            cw += arr[i] - cw % N;
            if (cw % N == arr[i]) {
                i++;
            }
        }

        long ccw = 0;
        i = 0;
        while (i != M) {
            int idx = i - 1;
            if (idx < 0) {
                idx = N - 1;
            }
            if (arr[idx] < ccw % N) {
                ccw += N;
            }
            ccw += arr[idx] - ccw % N;
            if (ccw % N == arr[idx]) {
                i = idx;
            }
        }

        if (cw < ccw) {
            System.out.println("CW");
        }
        else if (cw > ccw) {
            System.out.println("CCW");
        }
        else {
            System.out.println("EQ");
        }
    }

}
