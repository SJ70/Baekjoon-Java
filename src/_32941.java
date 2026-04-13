import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _32941 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(br.readLine());
        for (int i=0; i<N; i++) {
            int K = Integer.parseInt(br.readLine());
            boolean enable = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .anyMatch(A -> A == X);
            if (!enable) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

}
