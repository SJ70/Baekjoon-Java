import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _31821 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] prices = new int[n];
        for (int i=0; i<n; i++) {
            prices[i] = Integer.parseInt(br.readLine());
        }
        int m = Integer.parseInt(br.readLine());
        int result = 0;
        for (int i=0; i<m; i++) {
            int idx = Integer.parseInt(br.readLine()) - 1;
            result += prices[idx];
        }
        System.out.println(result);
    }

}
