import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2018 {

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());

        int left = 1;
        int right = 1;
        int sum = 1;

        int result = 0;

        while (true) {
            if (left > N) {
                break;
            }
//            System.out.printf("%d ~ %d : %d\n", left, right, sum);

            if (sum == N) {
                result++;
            }
            if (sum >= N) {
                sum -= left;
                left++;
            }
            if (sum < N) {
                right++;
                sum += right;
            }
        }

        System.out.println(result);
    }

}
