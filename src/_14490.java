import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14490 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), ":");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        for (int i = Math.min(a, b); i > 1; i--) {
            while (a % i == 0 && b % i == 0) {
                a/=i;
                b/=i;
            }
        }
        System.out.printf("%d:%d\n", a, b);
    }

}
