import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11257 {

    private static final double CUT_LINE_A = 35 * 0.3;
    private static final double CUT_LINE_B = 25 * 0.3;
    private static final double CUT_LINE_C = 40 * 0.3;
    private static final double CUT_LINE_SUM = 55;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t=0; t<T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String num = st.nextToken();
            double a = Double.parseDouble(st.nextToken());
            double b = Double.parseDouble(st.nextToken());
            double c = Double.parseDouble(st.nextToken());
            double sum = a + b + c;
            boolean success = (sum >= CUT_LINE_SUM && a >= CUT_LINE_A && b >= CUT_LINE_B && c >= CUT_LINE_C);
            sb.append(num);
            sb.append(' ');
            sb.append((int) sum);
            sb.append(' ');
            sb.append(success ? "PASS" : "FAIL");
            sb.append('\n');
        }
        System.out.print(sb);
    }

}
