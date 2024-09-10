import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _20365 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        char prev = '.';
        for (char c : br.readLine().toCharArray()) {
            if (prev != c) {
                prev = c;
                cnt++;
            }
        }
        System.out.println(cnt / 2 + 1);
    }
}
