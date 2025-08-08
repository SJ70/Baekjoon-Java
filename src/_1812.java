import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _1812 {

    private static int N;
    private static int[] arr;
    private static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        result = new int[N];
        loop: for (int k=0; k<=arr[0]; k++) {
            result[0] = arr[0] - k;
            for (int i=1; i<N; i++) {
                result[i] = arr[i-1] - result[i-1];
                if (result[i] < 0) {
                    continue loop;
                }
            }
            if (result[0] + result[N-1] == arr[N-1]) {
                for (int i=0; i<N; i++) {
                    System.out.println(result[i]);
                }
                return;
            }
        }
    }

}
