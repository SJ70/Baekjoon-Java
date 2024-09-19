import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _11727 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N+1];
        arr[0] = 1;
        for (int i=1; i<=N; i++) {
            arr[i] += arr[i-1];
            if (i>1) {
                arr[i] += arr[i-2] * 2;
            }
            arr[i] %= 10007;
        }
        System.out.println(arr[N]);
    }

}
