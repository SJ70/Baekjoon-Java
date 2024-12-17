import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2748 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if (N<=1) {
            System.out.println(N);
            return;
        }
        long a = 0;
        long b = 1;
        for (int i=2; i<=N; i++) {
            long c = a + b;
            a = b;
            b = c;
        }
        System.out.println(b);

    }

}
