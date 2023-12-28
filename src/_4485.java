import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class _4485 {

    private static int n;
    private static int[][] costs;
    private static int[][] usedCosts;
    private static PriorityQueue<State> states;

    private static class State {
        int r, c, cost;

        public State(int r, int c, int cost) {
            this.r = r;
            this.c = c;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int i=1; ; i++) {
            n = Integer.parseInt(br.readLine());
            if (n==0) {
                break;
            }
            costs = new int[n][n];
            usedCosts = new int[n][n];
            for (int r=0; r<n; r++) {
                costs[r] = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                for (int c=0; c<n; c++) {
                    usedCosts[r][c] = Integer.MAX_VALUE;
                }
            }
            states = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
            states.add(new State(0, 0, costs[0][0]));
            usedCosts[0][0] = costs[0][0];
            while (!states.isEmpty()) {
                bfs(states.poll());
            }
            sb.append("Problem ").append(i).append(": ").append(usedCosts[n-1][n-1]).append('\n');
        }
        System.out.print(sb);
    }

    private static int[] dr = {-1,0,1,0};
    private static int[] dc = {0,1,0,-1};
    private static void bfs(State state) {
        int r = state.r;
        int c = state.c;
        int cost = state.cost;
//        System.out.printf("%d %d %d\n",r,c,cost);
        for (int dir = 0; dir < 4; dir++) {
            int nextR = r + dr[dir];
            int nextC = c + dc[dir];
            if (nextR < 0 || nextR == n || nextC < 0 || nextC == n) {
                continue;
            }
            int nextCost = cost + costs[nextR][nextC];
            if (nextCost >= usedCosts[nextR][nextC] || nextCost >= usedCosts[n-1][n-1]) {
                continue;
            }
            usedCosts[nextR][nextC] = nextCost;
            states.add(new State(nextR, nextC, nextCost));
        }
    }

}
