import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _34032 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        int result = 0;
        for (char c : br.readLine().toCharArray()) {
            if (c == 'O') {
                result++;
            } else {
                result--;
            }
        }
        System.out.println(result >= 0 ? "Yes" : "No");
    }

}
