import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _32578 {

    private static int maxDepth = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();
        dfs(num, 1);
        System.out.println(maxDepth);
    }

    private static void dfs(String num, int depth) {
        int value = Integer.parseInt(num);
        if (value == 1) {
            return;
        }
        int root = (int) Math.sqrt(value);
        for (int i=2; i<=root; i++) {
            if (value % i == 0) {
                return;
            }
        }
        maxDepth = Math.max(depth, maxDepth);

        int length = num.length();
        if (length == 1) {
            return;
        }
        for (int i=0; i<length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j=0; j<length; j++) {
                if ((sb.length() == 0 && num.charAt(j) == '0')) {
                    continue;
                }
                if (i == j) {
                    continue;
                }
                sb.append(num.charAt(j));
            }
            dfs(sb.toString(), depth + 1);
        }
    }

}
