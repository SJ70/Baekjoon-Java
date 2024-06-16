import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _23037 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long result = 0;
        for (char c : br.readLine().toCharArray()) {
            int value = c - '0';
            result += Math.pow(value, 5);
        }
        System.out.println(result);

    }

}
