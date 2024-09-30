import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _6550 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = "";
        while ((input = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(input);
            String a = st.nextToken();
            String b = st.nextToken();
            int aIdx = 0;
            int bIdx = 0;
            boolean result = true;
            for (; aIdx < a.length(); aIdx++) {
                char target = a.charAt(aIdx);
                boolean foundTarget = false;
                for (; bIdx < b.length(); bIdx++) {
//                    System.out.printf("%d %d\n", aIdx, bIdx);
                    if (b.charAt(bIdx) == target) {
                        bIdx++;
                        foundTarget = true;
                        break;
                    }
                }
                if (!foundTarget) {
                    result = false;
                    break;
                }
            }
            sb.append(result ? "Yes\n" : "No\n");
//            System.out.println(result ? "Yes\n" : "No\n");
        }
        System.out.print(sb);
    }

}
