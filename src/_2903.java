import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2903 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int a = 2;
        for (int i=0; i<N; i++) {
            a = fn(a);
        }
        System.out.println(a * a);
    }

    private static int fn(int n) {
        return 2 * n - 1;
    }

}
