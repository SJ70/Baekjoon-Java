import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _11265 {

    private static int n;
    private static int t;

    private static long[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        dist = new long[n][n];
        for (int r=0; r<n; r++) {
            dist[r] = Arrays.stream(br.readLine().split(" "))
                    .mapToLong(Long::parseLong)
                    .toArray();
        }

        fw();

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<t; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            long expiredTime = Long.parseLong(st.nextToken());
            long requiredTime = dist[from][to];
            sb.append(expiredTime >= requiredTime ? "Enjoy other party" : "Stay here").append('\n');
        }
        System.out.print(sb);

    }

    private static void fw() {
        for (int across = 0; across < n; across++) {
            for (int from = 0; from < n; from++) {
                for (int to = 0; to < n; to++) {
                    dist[from][to] = Math.min(dist[from][to], dist[from][across] + dist[across][to]);
                }
            }
        }
    }

}
