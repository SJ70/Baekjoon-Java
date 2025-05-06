import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2985 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        if (a + b == c) {
            System.out.printf("%d+%d=%d\n", a, b, c);
            return;
        }
        if (a == b + c) {
            System.out.printf("%d=%d+%d\n", a, b, c);
            return;
        }
        if (a - b == c) {
            System.out.printf("%d-%d=%d\n", a, b, c);
            return;
        }
        if (a == b - c) {
            System.out.printf("%d=%d-%d\n", a, b, c);
            return;
        }
        if (a * b == c) {
            System.out.printf("%d*%d=%d\n", a, b, c);
            return;
        }
        if (a == b * c) {
            System.out.printf("%d=%d*%d\n", a, b, c);
            return;
        }
        if (a / b == c && a % b == 0) {
            System.out.printf("%d/%d=%d\n", a, b, c);
            return;
        }
        if (a == b / c && b % c == 0) {
            System.out.printf("%d=%d/%d\n", a, b, c);
            return;
        }
    }

}
