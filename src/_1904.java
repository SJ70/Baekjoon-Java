import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1904 {

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        if (n==1) {
            System.out.println(1);
            return;
        }

        int[] arr = new int[n];

        arr[0] = 1; // 1
        arr[1] = 2; // 11, 00

        for (int i = 2; i < n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
            arr[i] %= 15746;
        }
        System.out.println(arr[n - 1]);
    }

}
