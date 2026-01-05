import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _13877 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int t=1; t<=T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            sb.append(t).append(' ');

            String value = st.nextToken();

            try {
                int oct = Integer.parseInt(value, 8);
                sb.append(oct).append(' ');
            } catch (Exception e) {
                sb.append(0).append(' ');
            }

            int hex = Integer.parseInt(value, 16);

            sb.append(Integer.parseInt(value)).append(' ');
            sb.append(hex).append('\n');
        }
        System.out.print(sb);
    }

}
