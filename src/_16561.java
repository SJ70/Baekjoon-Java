import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _16561 {

    private static long result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n % 3 > 0) {
            System.out.println(0);
            return;
        }

        n /= 3;
        splitNum(n, 0);
        System.out.println(result);
    }

    private static void splitNum(int n, int depth) {
//        System.out.println(" ".repeat(depth) + n);
        if (n > 0 && depth == 2) {
            result++;
            return;
        }
        for (int i = 1; i <= n; i++) {
            splitNum(n - i, depth + 1);
        }
    }

}
