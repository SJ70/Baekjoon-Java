import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _21919 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] isNotDecimal = new boolean[1000001];
        isNotDecimal[1] = true;
        for (long i=2; i<=1000000; i++) {
            if (isNotDecimal[(int)i]) {
                continue;
            }
            for (long j=i*i; j<=1000000; j+=i) {
                isNotDecimal[(int)j] = true;
            }
        }
        long result = 1;
        int[] values = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).distinct().toArray();
        for (int value : values) {
            if (!isNotDecimal[value]) {
                result *= value;
            }
        }
        System.out.println(result == 1 ? -1 : result);
    }

}
