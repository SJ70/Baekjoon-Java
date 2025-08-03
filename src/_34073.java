import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class _34073 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        String result = Arrays.stream(br.readLine().split(" "))
                .map(str -> str + "DORO")
                .collect(Collectors.joining(" "));
        System.out.println(result);
    }

}
