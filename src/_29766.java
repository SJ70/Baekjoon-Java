import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _29766 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String target = "DKSH";
        int targetIndex = 0;

        String string = br.readLine();
        int length = string.length();

        int result = 0;
        for (int i = 0; i < length; i++) {
            if (string.charAt(i) == target.charAt(0)) {
                targetIndex = 1;
            }
            else if (string.charAt(i) == target.charAt(targetIndex)) {
                targetIndex++;
                if (targetIndex == target.length()) {
                    result++;
                    targetIndex = 0;
                }
            }
            else {
                targetIndex = 0;
            }
        }

        System.out.println(result);
    }

}
