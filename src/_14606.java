import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _14606 {

    private static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        getValue(N);
        System.out.println(result);
    }

    private static int getValue(int n) {
        if (n == 1) {
            return 0;
        }
        int a = n/2;
        int b = n - a;
        result += a * b;
        return getValue(a) + getValue(b);
    }

}
