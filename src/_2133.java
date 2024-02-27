import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2133 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        arr[0] = 1;

        for (int i = 0; i + 2 <= N; i += 2) {
            arr[i + 2] += arr[i];
            for (int j = i + 2; j <= N; j += 2) {
                arr[j] += 2 * arr[i];
            }
        }

        System.out.println(arr[N]);
    }

}
