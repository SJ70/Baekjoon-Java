import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _23972 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long K = Long.parseLong(st.nextToken());
        long N = Long.parseLong(st.nextToken());
        if (N == 1) {
            System.out.println(-1);
            return;
        }
        long result = (N * K) / (N - 1) + ((N * K) % (N - 1) > 0 ? 1 : 0);
        System.out.println(result);
    }

}
