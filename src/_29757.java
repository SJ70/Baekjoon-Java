import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _29757 {

    private static class Spot {
        int x, y;
        int idx;

        public Spot (int x, int y, int idx) {
            this.x = x;
            this.y = y;
            this.idx = idx;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Spot> spots = new PriorityQueue<>((s1, s2) -> s1.x == s2.x ? s1.y - s2.y : s1.x - s2.x);
        int N = Integer.parseInt(br.readLine());
        for (int i=1; i<=N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            Spot spot = new Spot(x, y, i);
            spots.add(spot);
        }
        StringBuilder sb = new StringBuilder();
        int prevSpotIdx = spots.poll().idx;
        for (int i=1; i<N; i++) {
            int spotIdx = spots.poll().idx;
            sb.append(String.format("%d %d\n", prevSpotIdx, spotIdx));
            prevSpotIdx = spotIdx;
        }
        System.out.print(sb);
    }

}
