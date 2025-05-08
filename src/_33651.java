import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _33651 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = br.readLine();
        int i = 0;
        for (char c : "UAPC".toCharArray()) {
            if (i < input.length() && input.charAt(i) == c) {
                i++;
            }
            else {
                sb.append(c);
            }
        }
        System.out.println(sb);
    }

}
