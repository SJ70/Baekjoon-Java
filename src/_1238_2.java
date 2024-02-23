import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _1238_2 {

    private static int E, V;
    private static int startPoint;

    private static ArrayList<Node>[] straightNodes;
    private static int[] straightDistances;

    private static ArrayList<Node>[] reversedNodes;
    private static int[] reversedDistances;

    private static class Node implements Comparable<Node>{
        int idx;
        int cost;

        public Node (int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }

        public int compareTo(Node node) {
            return this.cost - node.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        init();

        dijkstra(straightNodes, straightDistances);
        dijkstra(reversedNodes, reversedDistances);

        int maxDist = 0;
        for (int i=0; i<E; i++) {
            maxDist = Math.max(maxDist, straightDistances[i] + reversedDistances[i]);
        }
        System.out.println(maxDist);

    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        E = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        startPoint = Integer.parseInt(st.nextToken()) - 1;

        straightNodes = new ArrayList[E];
        straightDistances = new int[E];

        reversedNodes = new ArrayList[E];
        reversedDistances = new int[E];

        for (int i=0; i<E; i++) {
            straightNodes[i] = new ArrayList<>();
            reversedNodes[i] = new ArrayList<>();
        }

        for (int i=0; i<V; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            int dist = Integer.parseInt(st.nextToken());

            Node node = new Node(to, dist);
            straightNodes[from].add(node);

            Node reversedNode = new Node(from, dist);
            reversedNodes[to].add(reversedNode);
        }
    }

    private static void dijkstra(ArrayList<Node>[] nodes, int[] dists) {
        for (int i=0; i<E; i++) {
            dists[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(startPoint, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (node.cost >= dists[node.idx]) {
                continue;
            }
            dists[node.idx] = node.cost;

            for (Node connectedNode : nodes[node.idx]) {
                Node nextNode = new Node(connectedNode.idx, node.cost + connectedNode.cost);
                pq.add(nextNode);
            }
        }
    }

}
