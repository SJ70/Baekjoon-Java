import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2485 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] gap = new int[N-1];
        for (int i=0; i<N-1; i++) {
            gap[i] = arr[i+1] - arr[i];
        }

        int requiredGap = gap[0];
        for (int i=1; i<N-1; i++) {
            requiredGap = func(
                    Math.min(requiredGap, gap[i]),
                    Math.max(requiredGap, gap[i])
            );
        }

        int result =0;
        for (int i=1; i<N; i++) {
            result += (arr[i] - arr[i-1]) / requiredGap - 1;
        }
        System.out.println(result);
    }

    private static int func(int a, int b) {
        int v = b % a;
        if (v == 0) {
            return a;
        }
        else return func(v, a);
    }

}
