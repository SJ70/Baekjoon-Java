import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.StringTokenizer;

public class _17356 {

    private static final BigDecimal FOUR_HUNDRED = new BigDecimal(400);
    private static final BigDecimal ONE = new BigDecimal(1);
    private static final BigDecimal TEN = new BigDecimal(10);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        double m = (double)(b-a)/400;
        double result = 1 / (1 + Math.pow(10,m));
        System.out.println(result);
    }
}
