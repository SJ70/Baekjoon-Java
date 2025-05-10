import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _10822 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = Arrays.stream(br.readLine().split(","))
                .mapToInt(Integer::parseInt)
                .sum();
        System.out.println(result);
    }

}
