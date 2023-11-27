import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.MathContext;

public class _1709 {

    private static long R;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        R = n / 2;

        long quarterResult = 0;
        long highY = R;
        long lowY = R - 1;
        for (long x = 0; x < R; x++) {

            // highY가 선 위에 있을 때까지 내린다.
            while ((highY-1)*(highY-1) + x*x >= R*R) {
                highY--;
            }
            // lowY가 선 아래에 있을 때까지 내린다.
            while (lowY*lowY + (x+1)*(x+1) > R*R) {
                lowY--;
            }

//            System.out.printf("x : %d, highY : %d, lowY : %d\n",x,highY,lowY);

            quarterResult += highY - lowY;
        }

        System.out.println(quarterResult * 4);
    }

}
