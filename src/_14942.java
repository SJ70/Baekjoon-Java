import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _14942 {

    private static int N;
    private static int[] power;
    private static List<Node>[] paths;

    private static class Node {
        int dest;
        int dist;

        public Node(int dest, int dist) {
            this.dest = dest;
            this.dist = dist;
        }
    }

    private static PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.dist - b.dist);
    private static boolean[] visited;

    private static Node[] shortestPath;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        power = new int[N];
        for (int i=0; i<N; i++) {
            power[i] = Integer.parseInt(br.readLine());
        }

        paths = new List[N];
        for (int i=0; i<N; i++) {
            paths[i] = new ArrayList<>();
        }
        for (int i=0; i<N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int dist = Integer.parseInt(st.nextToken());
            paths[a].add(new Node(b, dist));
            paths[b].add(new Node(a, dist));
        }

        visited = new boolean[N];
        shortestPath = new Node[N];
        visited[0] = true;
        shortestPath[0] = new Node(-1, 0);
        for (Node node : paths[0]) {
            visited[node.dest] = true;
            pq.add(node);
            shortestPath[node.dest] = new Node(0, node.dist);
        }
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            for (Node nextNode : paths[node.dest]) {
                if (visited[nextNode.dest]) {
                    continue;
                }
                visited[nextNode.dest] = true;
                pq.add(new Node(nextNode.dest, node.dist + nextNode.dist));
                shortestPath[nextNode.dest] = new Node(node.dest, nextNode.dist);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<N; i++) {
            int powerSum = 0;
            int src = i;
            while (true) {
                Node path = shortestPath[src];
                if (path.dest == -1) {
                    sb.append(1);
                    sb.append('\n');
                    break;
                }
                if (powerSum + path.dist > power[i]) {
                    sb.append(src + 1);
                    sb.append('\n');
                    break;
                }
                powerSum += path.dist;
                src = path.dest;
            }
        }
        System.out.print(sb);
    }

}
