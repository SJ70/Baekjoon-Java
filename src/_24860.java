import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _24860 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] k = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long[] y = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long[] h = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long result = (k[0] * k[1] + y[0] * y[1]) * h[0] * h[1] * h[2];
        System.out.println(result);
    }

}
