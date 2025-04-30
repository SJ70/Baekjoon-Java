import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class _3047 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();
        String result = Arrays.stream(br.readLine().split(""))
                .map(str -> arr[str.charAt(0) - 'A'])
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
        System.out.println(result);
    }

}
