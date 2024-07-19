import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class _14405 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String split = Arrays.stream(Arrays.stream(Arrays.stream(str.split("pi"))
                .collect(Collectors.joining(" "))
                .split("ka"))
                .collect(Collectors.joining(" "))
                .split("chu"))
                .collect(Collectors.joining())
                .trim();
        System.out.println((split.length() == 0) ? "YES" : "NO");
    }

}
