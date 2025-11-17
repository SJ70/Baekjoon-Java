import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _33678 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N + 1];
        for (int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(st.nextToken()) + arr[i - 1];
        }

        int left = 1;
        int right = 1;

        int maxLength = -1;

        while (true) {
            if (right > N) {
                break;
            }
            int money = arr[N] - arr[right] + X * arr[left - 1];
//            System.out.printf("%d ~ %d, %d\n", left, right, money);
            if (money >= K) {
                maxLength = Math.max(maxLength, right - left + 1);
            }
            if (money <= K) {
                left++;
                right = Math.max(left, right);
            }
            if (money > K) {
                right++;
            }
        }

        System.out.println(maxLength);

    }

}
