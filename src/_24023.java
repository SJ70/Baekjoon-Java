import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _24023 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        int[] nums = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int cur = 0;
        int from = 0;
        int until = 0;
        for (int i=0; i<N; i++) {
            int num = nums[i];
            if ((target | num) != target) {
                cur = 0;
                from = i + 1;
                until = i + 1;
                continue;
            }

            cur = cur | num;
            if (cur == target) {
                System.out.printf("%d %d\n", from + 1, until + 1);
                return;
            }
            until++;
        }
        System.out.println(-1);
    }

}
