import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _27496 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int result = 0;
        int value = 0;
        for (int i=0; i<N; i++) {
            value += arr[i];
            if (i-L >= 0) {
                value -= arr[i-L];
            }
            if (value >= 129 && value <= 138) {
                result++;
            }
        }
        System.out.println(result);
    }
}
