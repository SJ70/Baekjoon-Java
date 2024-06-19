import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _28061 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int maxValue = 0;
        for (int i=N; i>=1; i--) {
            int value = Integer.parseInt(st.nextToken()) - i;
            maxValue = Math.max(maxValue, value);
        }
        System.out.println(maxValue);

    }

}
