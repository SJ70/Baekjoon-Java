import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2579 {

    private static int n;
    private static int[] stairs;

    private static int[] singleStep;
    private static int[] doubleStep;

    public static void main(String[] args) throws IOException {
        input();
        dp();
        System.out.println(Math.max(singleStep[n], doubleStep[n]));
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        stairs = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }
    }

    private static void dp() {
        singleStep = new int[n + 1];
        doubleStep = new int[n + 1];

        singleStep[1] = stairs[1];
        doubleStep[1] = stairs[1];

        if (n == 1) {
            return;
        }
        doubleStep[2] = stairs[2];

        for (int i = 2; i <= n; i++) {
            if (doubleStep[i-1] != 0) {
                singleStep[i] = doubleStep[i-1] + stairs[i];
            }
            if (Math.max(singleStep[i-2], doubleStep[i-2]) != 0) {
                doubleStep[i] = Math.max(singleStep[i-2], doubleStep[i-2]) + stairs[i];
            }
//            System.out.printf("%4d%4d\n", singleStep[i], doubleStep[i]);
        }
    }

}
