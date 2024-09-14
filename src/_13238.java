import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _13238 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] buy = new int[N];
        buy[0] = arr[0];
        for (int i=1; i<N; i++) {
            buy[i] = Math.min(arr[i], buy[i-1]);
        }

        int[] sell = new int[N];
        sell[N-1] = arr[N-1];
        for (int i=N-2; i>=0; i--) {
            sell[i] = Math.max(arr[i], sell[i+1]);
        }

        int maxResult = Integer.MIN_VALUE;
        for (int i=0; i<N; i++) {
            maxResult = Math.max(maxResult, sell[i] - buy[i]);
        }
        System.out.println(maxResult);

    }

}
