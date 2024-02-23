import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1238 {

    private static final long INF = Long.MAX_VALUE;
    private static int E, V;

    private static int partyPoint;
    private static long[][] dists;

    public static void main(String[] args) throws IOException {
        init();
        floydWarshall();
        System.out.println(getMaxDistToGoPartyAndComeBack());
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        E = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        partyPoint = Integer.parseInt(st.nextToken()) - 1;

        dists = new long[E][E];
        for (int i=0; i<E; i++) {
            Arrays.fill(dists[i], INF);
        }

        for (int i=0; i<V; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            long dist = Integer.parseInt(st.nextToken());
            dists[from][to] = dist;
        }
    }

    private static void floydWarshall() {
        for (int across = 0; across < E; across++) {
            for (int from = 0; from < E; from++) {
                if (from == across || dists[from][across] == INF) {
                    continue;
                }
                for (int to = 0; to < E; to++) {
                    if (to == across || to == from || dists[across][to] == INF) {
                        continue;
                    }
                    dists[from][to] = Math.min(dists[from][to], dists[from][across] + dists[across][to]);
                }
            }
        }
    }

    private static long getMaxDistToGoPartyAndComeBack() {
        long result = 0;
        for (int i=0; i<E; i++) {
            result = Math.max(result, dists[i][partyPoint] + dists[partyPoint][i]);
        }
        return result;
    }

}