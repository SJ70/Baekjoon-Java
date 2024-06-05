import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _25630 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int left = 0;
        int right = n - 1;
        int result = 0;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                result++;
            }
            left++;
            right--;
        }

        System.out.println(result);

    }

}
