import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class _26041 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stream<String> values = Arrays.stream(br.readLine().split(" "));
        String target = br.readLine();
        int result = (int) values
                .filter(value -> !value.equals(target) && value.startsWith(target))
                .count();
        System.out.println(result);
    }

}
