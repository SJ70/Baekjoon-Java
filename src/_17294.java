import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _17294 {

    private static final String TRUE = "◝(⑅•ᴗ•⑅)◜..°♡ 뀌요미!!";
    private static final String FALSE = "흥칫뿡!! <(￣ ﹌ ￣)>";

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();

        int length = arr.length;
        if (length == 1) {
            System.out.println(TRUE);
            return;
        }

        int diff = arr[0] - arr[1];
        for (int i=2; i<length; i++) {
            if (arr[i-1] - arr[i] != diff) {
                System.out.println(FALSE);
                return;
            }
        }

        System.out.println(TRUE);

    }

}
