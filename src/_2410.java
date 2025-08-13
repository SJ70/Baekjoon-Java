import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2410 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        arr[0] = 1;
        for (int j=1; j<=N; j*=2) {
            for (int i=0; i+j<=N; i++) {
                arr[i+j] += arr[i];
                arr[i+j] %= 1000000000;
            }
        }
        System.out.println(arr[N]);
    }
}
