import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.StringTokenizer;

public class _17235 {

    public static void main(String[] args) throws IOException {

        long belowUpper = Long.MIN_VALUE; // y = x + belowUpper   // belowUpper = y - x
        long underUpper = Long.MAX_VALUE; // y = x + underUpper   // underUpper = y - x
        long belowDown = Long.MIN_VALUE;  // y = - x + belowDown  // belowDown = x + y
        long underDown = Long.MAX_VALUE;  // y = - x + underDown  // underDown = x + y

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());
            belowUpper = Math.max(belowUpper, y - x);
            underUpper = Math.min(underUpper, y - x);
            belowDown = Math.max(belowDown, x + y);
            underDown = Math.min(underDown, x + y);
        }

//        System.out.printf("belowUpper : %d\n", belowUpper);
//        System.out.printf("underUpper : %d\n", underUpper);
//        System.out.printf("belowDown : %d\n", belowDown);
//        System.out.printf("underDown : %d\n", underDown);

        long height = Math.abs(belowUpper - underUpper);
        long width = Math.abs(belowDown - underDown);

        BigDecimal sideLength = new BigDecimal(Math.max(height, width));
        BigDecimal area = sideLength.multiply(sideLength);
        BigDecimal result = area.divide(new BigDecimal(2));

        System.out.printf(result.toString());
    }

}
