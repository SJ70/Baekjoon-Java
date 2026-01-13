import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _15813 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        int score = 0;
        for (char c : br.readLine().toCharArray()) {
            score += c - 'A' + 1;
        }
        System.out.println(score);
    }

}
