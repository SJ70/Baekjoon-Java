import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _31306 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = 0;
        int y = 0;
        for (char c : br.readLine().toCharArray()) {
            if (c == 'y') {
                y++;
            }
            else if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                a++;
            }
        }
        System.out.printf("%d %d\n", a, a + y);
    }

}
