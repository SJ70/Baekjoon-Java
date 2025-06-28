import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1977 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = (int) Math.sqrt(M); i*i <= N; i++) {
            if (i*i >= M) {
                sum += i*i;
                min = Math.min(i*i, min);
            }
        }
        if (sum == 0) {
            System.out.println(-1);
            return;
        }
        System.out.println(sum);
        System.out.println(min);
    }

}
