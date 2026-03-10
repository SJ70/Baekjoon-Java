import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _28808 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int result = 0;
        for (int i=0; i<N; i++) {
            String str = br.readLine();
            if (str.contains("+")) {
                result++;
            }
        }
        System.out.println(result);
    }

}
