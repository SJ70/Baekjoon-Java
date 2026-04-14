import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10409 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int result = 0;
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            int value = Integer.parseInt(st.nextToken());
            if (T < value) {
                break;
            }
            T -= value;
            result++;
        }
        System.out.println(result);
    }

}
