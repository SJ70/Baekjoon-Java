import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _15080 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int from = getValue(br.readLine());
        int to = getValue(br.readLine());
        int result = to - from;
        if (result < 0) {
            result += 3600 * 24;
        }
        System.out.println(result);
    }

    private static int getValue(String str) {
        int[] arr = Arrays.stream(str.split(" : ")).mapToInt(Integer::parseInt).toArray();
        return arr[0] * 3600 + arr[1] * 60 + arr[2];
    }

}
