import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2078 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int left = 0;
        int right = 0;
        while (true) {
            if (a > b) {
                left++;
                a -= b;
            }
            if (a < b) {
                right++;
                b -= a;
            }
            if (a == 1 && b == 1) {
                break;
            }
        }
        System.out.printf("%d %d\n", left, right);
    }

}
