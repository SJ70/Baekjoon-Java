import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _24416 {

    private static long fib1cnt = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        fib(n);
        int fib2cnt = Math.max(0, n-2);
        System.out.printf("%d %d\n", fib1cnt, fib2cnt);
    }

    private static long fib(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        fib1cnt++;
        return fib(n-1) + fib(n-2);
    }

}
