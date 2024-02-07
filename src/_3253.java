import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _3253 {

    private static final int INF = Integer.MAX_VALUE;

    private static class Node {
        int index;
        int dist;

        public Node (int index, int dist) {
            this.index = index;
            this.dist = dist;
        }

        public String toString() {
            return String.format("[%d, %d]", index, dist);
        }
    }

    private static int n;
    private static int startIndex;
    private static int endIndex;

    private static List<Node>[] nodes;

    private static int[] distances;

    public static void main(String[] args) throws IOException {
        input();
        dijkstra();
        printAnswer();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        startIndex = Integer.parseInt(st.nextToken());
        endIndex = Integer.parseInt(st.nextToken());

        nodes = new List[n + 1];
        for (int i=1; i<=n; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());

            if (k > 0) {
                nodes[i].add(new Node(Integer.parseInt(st.nextToken()), 0));
            }
            while (st.hasMoreTokens()) {
                nodes[i].add(new Node(Integer.parseInt(st.nextToken()), 1));
            }
        }
    }

    private static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.dist));
        distances = new int[n + 1];
        Arrays.fill(distances, INF);

        distances[startIndex] = 0;
        pq.add(new Node(startIndex, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int index = node.index;
            int dist = node.dist;

            if (dist > distances[index]) {
                continue;
            }

            if (index == endIndex) {
                return;
            }

            for (Node connectedNode : nodes[index]) {
                int indexOfConnectedNode = connectedNode.index;
                int distanceToConnectedNode = dist + connectedNode.dist;
                if (distanceToConnectedNode < distances[indexOfConnectedNode]) {
                    distances[indexOfConnectedNode] = distanceToConnectedNode;
                    pq.add(new Node(indexOfConnectedNode, distanceToConnectedNode));
                }
            }
//            System.out.println(Arrays.toString(nodes));
//            System.out.println(pq);
//            System.out.println(Arrays.toString(distances));
        }
    }

    private static void printAnswer() {
        int result = distances[endIndex] == INF ? -1 : distances[endIndex];
        System.out.println(result);
    }

}
