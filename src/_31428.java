import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class _31428 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();

        List<String> arr = Arrays.stream(br.readLine().split(" ")).collect(Collectors.toList());
        String target = br.readLine();

        System.out.println(arr.stream().filter(value -> value.equals(target)).count());

    }

}
