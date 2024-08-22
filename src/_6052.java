import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _6052 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] sumOfDivisors = new int[20000];
        for (int i=1; true; i++) {
            sumOfDivisors[i] = 1;
            int sqrt = (int) Math.sqrt(i);
            for (int j=2; j<=sqrt; j++) {
                if (i % j == 0) {
                    sumOfDivisors[i] += j;
                    int div = i / j;
                    if (j != div) {
                        sumOfDivisors[i] += div;
                    }
                }
            }
            if (sumOfDivisors[i] < i && sumOfDivisors[sumOfDivisors[i]] == i && i >= N) {
                if (sumOfDivisors[i] >= N) {
                    System.out.printf("%d %d", sumOfDivisors[i], i);
                }
                else {
                    System.out.printf("%d %d", i, sumOfDivisors[i]);
                }
                return;
            }
        }

    }

}
