import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _1584 {

    private static final int N = 500;
    private static final int INF = Integer.MAX_VALUE;

    private static class Node {
        int r, c;
        int value;

        public Node(int r, int c, int value) {
            this.r = r;
            this.c = c;
            this.value = value;
        }
    }

    private static PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.value - b.value);
    private static int[][] costs;
    private static boolean[][] visited;

    private static final int[] DR = new int[]{-1, 0, 1, 0};
    private static final int[] DC = new int[]{0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        init();

        pq.add(new Node(0, 0, 0));
        visited[0][0] = true;

        while(!pq.isEmpty()) {
            int r = pq.peek().r;
            int c = pq.peek().c;
            int cost = pq.poll().value;

            if (r == N && c == N) {
                System.out.println(cost);
                pq.clear();
                return;
            }

            for (int dir=0; dir<4; dir++) {
                int nextR = r + DR[dir];
                int nextC = c + DC[dir];
                if (nextR >= 0 && nextR <= N && nextC >= 0 && nextC <= N && !visited[nextR][nextC] && costs[nextR][nextC] < INF) {
                    visited[nextR][nextC] = true;
                    int nextCost = cost + costs[nextR][nextC];
                    pq.add(new Node(nextR, nextC, nextCost));
                }
            }
        }

        System.out.println(-1);

    }

    private static void init() throws IOException {

        costs = new int[N+1][N+1];
        visited = new boolean[N+1][N+1];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());
            for (int r=r1; r1<=r2 ? r<=r2 : r>=r2; r += (r1<=r2 ? 1 : -1)) {
                for (int c=c1; c1<=c2 ? c<=c2 : c>=c2; c += (c1<=c2 ? 1 : -1)) {
                    costs[r][c] = 1;
                }
            }
        }

        int m = Integer.parseInt(br.readLine());
        for (int i=0; i<m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());
            for (int r=r1; r1<=r2 ? r<=r2 : r>=r2; r += (r1<=r2 ? 1 : -1)) {
                for (int c=c1; c1<=c2 ? c<=c2 : c>=c2; c += (c1<=c2 ? 1 : -1)) {
                    costs[r][c] = INF;
                }
            }
        }
    }

}
