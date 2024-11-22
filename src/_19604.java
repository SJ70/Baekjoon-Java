import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _19604 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        for (int i=0; i<N; i++) {
            int[] values = Arrays.stream(br.readLine().split(",")).mapToInt(Integer::parseInt).toArray();
            minX = Math.min(minX, values[0]);
            minY = Math.min(minY, values[1]);
            maxX = Math.max(maxX, values[0]);
            maxY = Math.max(maxY, values[1]);
        }
        System.out.printf("%d,%d\n%d,%d\n", minX - 1, minY - 1, maxX + 1, maxY + 1);
    }

}
