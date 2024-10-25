import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _31831 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int result = 0;
        int stress = 0;
        for (int i=0; i<N; i++) {
            stress += Integer.parseInt(st.nextToken());
            if (stress < 0) {
                stress = 0;
            }
            if (stress >= M) {
                result++;
            }
        }
        System.out.println(result);
    }

}
