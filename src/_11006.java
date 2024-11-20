import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11006 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t=0; t<T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int maxLegs = M * 2;
            int oneLegs = maxLegs - N;
            int twoLegs = M - oneLegs;
            sb.append(oneLegs);
            sb.append(' ');
            sb.append(twoLegs);
            sb.append('\n');
        }
        System.out.print(sb);
    }

}
