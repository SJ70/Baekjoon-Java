import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class _12605 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        Stack<String> words = new Stack<>();
        for (int t=1; t<=T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                words.push(st.nextToken());
            }
            sb.append(String.format("Case #%d: ", t));
            while (!words.isEmpty()) {
                sb.append(words.pop());
                sb.append(words.isEmpty() ? "\n" : " ");
            }
        }

        System.out.print(sb);

    }

}
