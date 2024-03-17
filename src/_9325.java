import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _9325 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t=0; t<T; t++) {
            int result = Integer.parseInt(br.readLine());
            int N = Integer.parseInt(br.readLine());
            for (int i=0; i<N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                result += Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken());
            }
            sb.append(result);
            sb.append('\n');
        }

        System.out.print(sb);

    }

}
