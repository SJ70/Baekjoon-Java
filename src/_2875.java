import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2875 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        M *= 2;
        while (K > 0) {
            if (N >= M) {
                N--;
                K--;
            }
            else {
                M-=2;
                K--;
            }
        }
        System.out.println(Math.min(N, M) / 2);
    }

}
