import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _23938 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String input = br.readLine();
        int sum = Arrays.stream(input.split(" "))
                .map(Integer::parseInt)
                .reduce(0, Integer::sum);

        if (sum < 0) {
            System.out.println("Left");
            return;
        }
        if (sum > 0) {
            System.out.println("Right");
            return;
        }
        System.out.println("Stay");
    }

}
