import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14429 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int shortestIdx = 0;
        int shortest = Integer.MAX_VALUE;
        for (int i=1; i<=N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int j = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int r = (j-1) % (1+m);
            int result = 1;
            int value = r;
            while (true) {
                result++;
                value += m;
                if (value >= j) {
                    break;
                }
                result++;
                value++;
            }
            if (result < shortest) {
                shortest = result;
                shortestIdx = i;
            }
        }
        System.out.printf("%d %d", shortestIdx, shortest);
    }

}
