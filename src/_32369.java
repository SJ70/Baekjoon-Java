import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _32369 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int good = 1;
        int bad = 1;
        for (int i=0; i<N; i++) {
            good += A;
            bad += B;
            if (good < bad) {
                int tmp = good;
                good = bad;
                bad = tmp;
            }
            if (good == bad) {
                bad--;
            }
        }
        System.out.printf("%d %d\n", good, bad);
    }

}
