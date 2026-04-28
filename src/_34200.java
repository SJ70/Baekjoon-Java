import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _34200 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cur = 0;
        int result = 0;
        for (int i=0; i<N; i++) {
            int value = Integer.parseInt(st.nextToken());
            if (cur == value) {
                System.out.println(-1);
                return;
            }
            while (cur < value) {
                cur += 2;
                result++;
            }
            if (cur == value) {
                cur++;
                result++;
            }
        }
        System.out.println(result);
    }

}
