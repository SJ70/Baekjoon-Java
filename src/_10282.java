import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class _10282 {

    private static final int INF = Integer.MAX_VALUE;

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static int E, V, START;

    private static List<Node>[] nodes;

    private static int[] costs;

    private static class Node {

        int idx;
        int cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            input();
            dijkstra();
            sb.append(getResult());
        }
        System.out.print(sb);
    }

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        E = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        START = Integer.parseInt(st.nextToken());

        nodes = new List[E + 1];

        for (int i = 1; i <= E; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < V; i++) {
            st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            nodes[from].add(new Node(to, cost));
        }

    }

    private static void dijkstra() {
        costs = new int[E + 1];
        Arrays.fill(costs, INF);
        costs[START] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.cost));
        pq.add(new Node(START, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (costs[node.idx] < node.cost) {
                continue;
            }

            for (Node connectedNode : nodes[node.idx]) {
                int idx = connectedNode.idx;
                int cost = node.cost + connectedNode.cost;
                if (cost < costs[idx]) {
                    costs[idx] = cost;
                    pq.add(new Node(idx, cost));
                }
            }
        }
    }

    private static String getResult() {
        List<Integer> infectedComputerCosts = Arrays.stream(costs)
                .filter(c -> c != INF)
                .boxed()
                .collect(Collectors.toList());

//        System.out.println(Arrays.toString(costs));
//        System.out.println(infectedComputerCosts);

        int cnt = infectedComputerCosts.size();
        int max = infectedComputerCosts.stream().max(Integer::compareTo).get();

        return String.format("%d %d\n", cnt, max);
    }

}
