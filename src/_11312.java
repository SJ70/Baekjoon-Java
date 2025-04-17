import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11312 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for (int t=0; t<N; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int div = A/B;
            long result = 0;
            for (long i=1; i<=div; i++) {
                result += 2 * (i - 1) + 1;
            }
            sb.append(result);
            sb.append('\n');
        }
        System.out.print(sb);
    }

}
