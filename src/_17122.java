import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _17122 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t=0; t<T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String a = st.nextToken();
            int r1 = a.charAt(0) - 'A';
            int c1 = a.charAt(1) - '1';

            String b = st.nextToken();
            int r2 = (Integer.parseInt(b) - 1) / 8;
            int c2 = (Integer.parseInt(b) - 1) % 8;

            boolean sameColor = (r1%2 == c1%2) == (r2%2 == c2%2);
            sb.append(sameColor ? "YES\n" : "NO\n");
        }
        System.out.print(sb);

    }

}
