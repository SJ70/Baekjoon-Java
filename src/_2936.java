import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2936 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        double x = 0;
        double y = 0;
        if (a > 0 && b > 0) {
            if (a > b) {
                x = 0;
                y = f1(a, b);
            }
            else if (a < b) {
                x = f1(b, a);
                y = 0;
            }
            else { // a == b
                x = 0;
                y = 0;
            }
        }
        else if (a == 0 && b > 0) {
            if (b == 250) {
                x = 125;
                y = 0;
            }
            else if (b > 125) {
                x = f2(a, b);
                y = 0;
            }
            else if (b < 125) {
                x = f3(a, b);
                y = 250 - x;
            }
            else { // b == 125
                x = 250;
                y = 0;
            }
        }
        else if (a > 0 && b == 0) {
            if (a == 250) {
                x = 0;
                y = 125;
            }
            else if (a > 125) {
                x = f2(b, a);
                y = 0;
            }
            else if (a < 125) {
                y = f3(b, a);
                x = 250 - y;
            }
            else { // a == 125
                x = 0;
                y = 250;
            }
        }
        else if (a == 0 && b == 0) {
            x = 125;
            y = 125;
        }
        System.out.printf("%.2f %.2f\n", x, y);
    }

    private static double f1(int a, int b) {
        return 125 - 125f * b / a;
    }

    private static double f2(int a, int b) {
        return 250f * 250 / (2 * b);
    }

    private static double f3(int a, int b) {
        return 250f * 250 / (500 - 2 * b);
    }

}
