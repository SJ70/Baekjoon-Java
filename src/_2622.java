import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2622 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = 0;
        for (int a=1; a<n; a++) {
            for (int b=a; a+b<n; b++) {
                int c = n - a - b;
                if (c < b) {
                    continue;
                }
                if (a + b > c) {
                    result++;
                }
            }
        }
        System.out.println(result);
    }

}
