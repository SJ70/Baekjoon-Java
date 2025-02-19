import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _17201 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        char prev = 'a';
        for (char c : str.toCharArray()) {
            if (prev == c) {
                System.out.println("No");
                return;
            }
            prev = c;
        }
        System.out.println("Yes");
    }

}
