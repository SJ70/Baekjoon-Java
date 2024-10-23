import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class _20336 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        String result = Arrays.stream(br.readLine().split(" ")).collect(Collectors.joining("\n"));
        System.out.println(result);
    }

}
