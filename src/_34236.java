import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _34236 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] nums = br.readLine().split(" ");
        int result = 2 * Integer.parseInt(nums[N - 1]) - Integer.parseInt(nums[N - 2]);
        System.out.println(result);
    }

}
