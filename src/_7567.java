import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _7567 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char prev = '.';
        int result = 0;
        for (char c : br.readLine().toCharArray()) {
            result += (c == prev) ? 5 : 10;
            prev = c;
        }
        System.out.println(result);
    }

}
