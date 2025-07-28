import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _15781 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        int a = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .max()
                .getAsInt();
        int b = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .max()
                .getAsInt();
        System.out.println(a + b);
    }

}
