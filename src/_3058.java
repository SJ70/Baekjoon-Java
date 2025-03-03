import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _3058 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i=0; i<N; i++) {
            int sum = 0;
            int minEven = Integer.MAX_VALUE;
            for (int value : Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray()) {
                if (value % 2 == 0) {
                    sum += value;
                    minEven = Math.min(value, minEven);
                }
            }
            System.out.printf("%d %d\n", sum, minEven);
        }
    }

}
