import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14912 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        char d = st.nextToken().charAt(0);
        long result = 0;
        for (int i=1; i<=n; i++) {
            for (char c : String.valueOf(i).toCharArray()) {
                if (c == d) {
                    result++;
                }
            }
        }
        System.out.println(result);
    }

}
