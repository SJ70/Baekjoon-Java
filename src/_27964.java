import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _27964 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] strings = br.readLine().split(" ");
        System.out.println(
                Arrays.stream(strings)
                        .filter(str -> str.length() >= 6)
                        .distinct()
                        .map(str -> str.substring(str.length() - 6))
                        .filter(str -> str.equals("Cheese"))
                        .count() >= 4 ? "yummy" : "sad"
        );
    }

}
