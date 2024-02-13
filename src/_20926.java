import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _20926 {

    // 2차원 배열을 간선 형태로 변환한다.
    // 바위에 막히는 간선과, 사다리까지 도달하는 간선만 만들어놓는다.

    private static String[] maze;
    private static int R, C;

    private static List<Node>[] nodes;
    private static int start_idx;
    private static int destination_idx;

    private static long[] costs;

    private static final long INF = Long.MAX_VALUE;

    private static class Node {
        int idx;   //  idx = r * R + c
        long cost;

        public Node(int idx, long cost) {
            this.idx = idx;
            this.cost = cost;
        }

        public String toString() {
            return String.format("-> %s : %d", idx, cost);
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        makeGraphFromVortex();
//        System.out.println(Arrays.toString(nodes));
        dijkstra();
        System.out.println(costs[destination_idx] == INF ? -1 : costs[destination_idx]);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        maze = new String[R];
        for (int r=0; r<R; r++) {
            maze[r] = br.readLine();
        }
    }

    private static final int[] DR = new int[] {1, 0, -1, 0};
    private static final int[] DC = new int[] {0, 1, 0, -1};

    private static void makeGraphFromVortex() {
        int size = R * C;
        nodes = new List[size];

        for (int i=0; i<size; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i=0; i<size; i++) {

            int r = i / C;
            int c = i % C;
            char value = maze[r].charAt(c);

            // 시작점 인덱스 기록
            if (value == 'T') {
                start_idx = i;
            }

            // 도착점
            // 도착점 인덱스 기록
            // 도착점에 도달할 수 있는 출발점들을 모두 측정
            else if (value == 'E') {
                destination_idx = i;

                for (int dir=0; dir<4; dir++) {

                    int from_r = r;
                    int from_c = c;
                    long cost = 0;

                    while (true) {
                        from_r -= DR[dir];
                        from_c -= DC[dir];

                        // out of range
                        if (from_r < 0 || from_r == R || from_c < 0 || from_c == C) {
                            break;
                        }
                        char from_value = maze[from_r].charAt(from_c);

                        // 돌과 구멍에서는 출발할 수 없음
                        if (from_value == 'R' || from_value == 'H') {
                            break;
                        }

                        int from_idx = from_r * C + from_c;
                        nodes[from_idx].add(new Node(i, cost));

                        // 출발점의 가중치는 0
                        if (from_value != 'T') {
                            cost += from_value - '0';
                        }
                    }
                }
            }

            // 돌
            // 돌 앞에 도달할 수 있는 출발점들을 모두 측정
            else if (value == 'R') {
                for (int dir=0; dir<4; dir++) {
                    int to_r = r - DR[dir];
                    int to_c = c - DC[dir];
                    int to_idx = to_r * C + to_c;

                    // out of range | 출발지,도착지,돌,구멍이 바로 앞이라면 측정할 가치 없음
                    if (to_r < 0 || to_r >= R || to_c < 0 || to_c >= C || !isNumber(to_r, to_c)) {
                        continue;
                    }
                    long cost = maze[to_r].charAt(to_c) - '0';

                    int from_r = to_r;
                    int from_c = to_c;

                    while (true) {
                        from_r -= DR[dir];
                        from_c -= DC[dir];

                        // out of range
                        if (from_r < 0 || from_r >= R || from_c < 0 || from_c >= C) {
                            break;
                        }
                        char from_value = maze[from_r].charAt(from_c);

                        // 돌, 구멍에서는 출발할 수 없음 | 도착지에선 출발할 필요가 없음
                        if (from_value == 'R' || from_value == 'H' || from_value == 'E') {
                            break;
                        }

                        int from_idx = from_r * C + from_c;
                        nodes[from_idx].add(new Node(to_idx, cost));

                        // 출발점의 가중치는 0
                        if (from_value != 'T') {
                            cost += from_value - '0';
                        }
                    }
                }
            }

        }
    }

    private static boolean isNumber(int r, int c) {
        char value = maze[r].charAt(c);
        return value >= '0' && value <= '9';
    }

    private static void dijkstra() {
        int size = R * C;
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingLong(node -> node.cost));

        costs = new long[size];
        Arrays.fill(costs, INF);

        pq.add(new Node(start_idx, 0));
        costs[start_idx] = 0;

        while (!pq.isEmpty()) {
            Node from = pq.poll();
            int idx = from.idx;
            long cost = from.cost;

            if (idx == destination_idx) {
                break;
            }

            if (costs[idx] < cost) {
                continue;
            }

            for (Node to : nodes[idx]) {
                long entire_cost = to.cost + cost;
                if (costs[to.idx] > entire_cost) {
                    costs[to.idx] = entire_cost;
                    pq.add(new Node(to.idx, entire_cost));
                }
            }
        }
    }

}
