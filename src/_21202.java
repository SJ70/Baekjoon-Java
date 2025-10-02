import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _21202 {

    private static int islandCnt;
    private static int bridgeCnt;

    private static int[] powers;
    private static List<Integer>[] bridges;

    private static int power;
    private static boolean[] visited;

    private static PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> powers[a] - powers[b]);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        islandCnt = Integer.parseInt(st.nextToken());
        bridgeCnt = Integer.parseInt(st.nextToken());

        powers = new int[islandCnt];
        bridges = new ArrayList[islandCnt];
        visited = new boolean[islandCnt];

        for (int i=0; i<islandCnt; i++) {
            bridges[i] = new ArrayList<>();
        }
        for (int i=0; i<bridgeCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            bridges[a].add(b);
            bridges[b].add(a);
        }
        for (int i=0; i<islandCnt; i++) {
            powers[i] = Integer.parseInt(br.readLine());
        }

        visited[0] = true;
        power = powers[0];
        for (int i : bridges[0]) {
            visited[i] = true;
            pq.add(i);
        }

        while (!pq.isEmpty()) {
            int islandIdx = pq.poll();
            if (power > powers[islandIdx]) {
                power += powers[islandIdx];
            }
            else {
                break;
            }
            for (int i : bridges[islandIdx]) {
                if (!visited[i]) {
                    visited[i] = true;
                    pq.add(i);
                }
            }
        }
        System.out.println(power);
    }

}
