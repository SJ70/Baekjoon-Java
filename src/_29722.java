import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _29722 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] values = Arrays.stream(br.readLine().split("-")).mapToInt(Integer::parseInt).toArray();
        int add = Integer.parseInt(br.readLine());
        values[2] += add;
        if (values[2] > 30) {
            values[1] += (values[2] - 1) / 30;
            values[2] = (values[2] - 1) % 30 + 1;
        }
        if (values[1] > 12) {
            values[0] += (values[1] - 1) / 12;
            values[1] = (values[1] - 1) % 12 + 1;
        }
        System.out.printf("%d-%02d-%02d\n", values[0], values[1], values[2]);
    }

}
