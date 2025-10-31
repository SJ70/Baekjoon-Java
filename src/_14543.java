import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.StringTokenizer;

public class _14543 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t=1; t<=T; t++) {
            sb.append("Equation ");
            sb.append(t);
            sb.append('\n');

            StringTokenizer st = new StringTokenizer(br.readLine());
            String withX = st.nextToken();
            String withoutX = withX.substring(0, withX.length() - 1);
            BigDecimal mul = new BigDecimal(withoutX);
            st.nextToken();
            BigDecimal zero = new BigDecimal(0);
            BigDecimal result = zero.subtract(new BigDecimal(st.nextToken()));
            st.nextToken();
            result = result.add(new BigDecimal(st.nextToken()));

            if (result.equals(zero)) {
                if (mul.equals(zero)) {
                    sb.append("More than one solution.\n");
                }
                else {
                    sb.append("x = 0.000000\n");
                }
            }
            else if (mul.equals(zero)) {
                sb.append("No solution.\n");
            }
            else {
                BigDecimal x = result.divide(mul, 100, BigDecimal.ROUND_FLOOR);
                DecimalFormat df = new DecimalFormat("0.000000");
                df.setRoundingMode(RoundingMode.DOWN);
                sb.append("x = ");
                sb.append(df.format(x));
                sb.append('\n');
            }

            if (t < T) {
                sb.append('\n');
            }
        }
        System.out.print(sb);

    }

}
