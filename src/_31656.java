import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _31656 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char prev = '-';
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c == prev) {
                continue;
            }
            sb.append(c);
            prev = c;
        }
        System.out.println(sb);

    }

}
