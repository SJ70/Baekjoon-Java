import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _14584 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String code = br.readLine();
        int N = Integer.parseInt(br.readLine());
        String[] words = new String[N];
        for (int i=0; i<N; i++) {
            words[i] = br.readLine();
        }

        for (int i=0; i<26; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j=0; j<code.length(); j++) {
                char value = (char) (code.charAt(j) + i);
                if (value > 'z') {
                    value -= 26;
                }
                sb.append(value);
            }
            String decoded = sb.toString();
            for (String word : words) {
                if (decoded.contains(word)) {
                    System.out.println(decoded);
                    return;
                }
            }
        }
    }

}
