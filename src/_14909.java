import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _14909 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long result = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).filter(value -> value > 0).count();
        System.out.println(result);
    }

}
