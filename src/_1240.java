import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class _1240 {

    private static final int INF = Integer.MAX_VALUE;

    private static int N, M;
    private static int[][] dists;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dists = new int[N][N];
        for (int r=0; r<N; r++) {
            for (int c=0; c<N; c++) {
                if (r == c) {
                    continue;
                }
                dists[r][c] = INF;
            }
        }

        for (int i=0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            int dist = Integer.parseInt(st.nextToken());
            dists[from][to] = dists[to][from] = dist;
        }

        for (int across=0; across<N; across++) {
            for (int from=0; from<N; from++) {
                if (from == across || dists[from][across] == INF) {
                    continue;
                }
                for (int to=0; to<N; to++) {
                    if (to == across || to == from || dists[across][to] == INF) {
                        continue;
                    }
                    dists[from][to] = Math.min(dists[from][to], dists[from][across] + dists[across][to]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            sb.append(dists[from][to]).append('\n');
        }
        System.out.print(sb);

//        System.out.println(Arrays.stream(dists)
//                        .map(arr -> Arrays.stream(arr).mapToObj(Integer::valueOf).collect(Collectors.toList()))
//                        .map(List::toString)
//                        .collect(Collectors.joining("\n")));
    }

}
