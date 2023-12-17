import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _6764 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = new int[4];
        for (int i=0; i<4; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        int[] diff = new int[3];
        for (int i=0; i<3; i++) {
            diff[i] = nums[i+1] - nums[i];
        }

        int[] diffValue = Arrays.stream(diff)
                .map(value -> Integer.compare(value, 0))
                .distinct()
                .toArray();

        if (diffValue.length > 1) {
            System.out.println("No Fish");
            return;
        }
        if (diffValue[0] == 1) {
            System.out.println("Fish Rising");
            return;
        }
        if (diffValue[0] == -1) {
            System.out.println("Fish Diving");
            return;
        }
        if (diffValue[0] == 0) {
            System.out.println("Fish At Constant Depth");
            return;
        }
    }

}
