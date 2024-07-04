import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _9782 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = "";
        for (int i=1; true; i++) {
            input = br.readLine();
            if (input.equals("0")) {
                break;
            }
            int[] nums = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
            int n = nums[0];
            double result = 0f;
            switch (n % 2) {
                case 1: result = nums[(n+1)/2]; break;
                case 0: result = (double)(nums[n/2] + nums[n/2 + 1]) / 2; break;
            }
            sb.append(String.format("Case %d: %.1f\n", i, result));
        }
        System.out.print(sb);
    }

}
