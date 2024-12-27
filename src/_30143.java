import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _30143 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t=0; t<T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int A = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());
            int result = 0;
            for (int i=0; i<N; i++) {
                result += A + D * i;
            }
            sb.append(result);
            sb.append('\n');
        }
        System.out.print(sb);
    }

}
