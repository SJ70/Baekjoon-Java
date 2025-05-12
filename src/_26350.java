import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _26350 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t=0; t<T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            sb.append("Denominations:");
            int prev = -1;
            boolean isGood = true;
            for (int i=0; i<N; i++) {
                int value = Integer.parseInt(st.nextToken());
                sb.append(" ");
                sb.append(value);
                if (value >= prev * 2) {
                    prev = value;
                }
                else {
                    isGood = false;
                }
            }
            sb.append('\n');
            sb.append(isGood ? "Good" : "Bad");
            sb.append(" coin denominations!");
            if (t < T - 1) {
                sb.append("\n\n");
            }
        }
        System.out.println(sb);
    }

}
