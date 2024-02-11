import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _11726 {

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());

        int[] arr = new int[n+1];
        arr[0] = 1;

        for (int i=1; i<=n; i++) {
            arr[i] += arr[i-1];
            if (i-2 >= 0) {
                arr[i] += arr[i-2];
            }
            arr[i] %= 10007;
        }
        System.out.println(arr[n]);
    }

}
