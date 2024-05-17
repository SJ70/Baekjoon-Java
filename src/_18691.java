import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _18691 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t=0; t<T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int g = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int result = Math.max(e - c, 0) * (g * 2 - 1);
            sb.append(result).append('\n');
        }

        System.out.print(sb);

    }

}
