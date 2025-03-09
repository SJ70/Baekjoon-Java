import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _31612 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        int result = 0;
        for (char c : br.readLine().toCharArray()) {
            result += c == 'o' ? 1 : 2;
        }
        System.out.println(result);
    }

}
