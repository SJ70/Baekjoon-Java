import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class _18126 {

    private static int N;
    private static long[] results;
    private static boolean[] visited;

    private static class Node {
        int to;
        long dist;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        List<Node>[] nodes = new List[N];
        for (int i=0; i<N; i++) {
            nodes[i] = new ArrayList<>();
        }
        results = new long[N];
        visited = new boolean[N];

        for (int i=0; i<N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            long dist =  Long.parseLong(st.nextToken());

            Node node1 = new Node();
            node1.to = to;
            node1.dist = dist;
            nodes[from].add(node1);

            Node node2 = new Node();
            node2.to = from;
            node2.dist = dist;
            nodes[to].add(node2);
        }

        Queue<Node> q = new ArrayDeque<>(nodes[0]);
        visited[0] = true;
        while (!q.isEmpty()) {
            Node node = q.poll();
            results[node.to] = node.dist;
            for (Node nextNode : nodes[node.to]) {
                if (visited[nextNode.to]) {
                    continue;
                }
                visited[nextNode.to] = true;
                Node nextNextNode = new Node();
                nextNextNode.to = nextNode.to;
                nextNextNode.dist = node.dist + nextNode.dist;
                q.add(nextNextNode);
            }
        }

        long result = Arrays.stream(results)
                .max()
                .getAsLong();
        System.out.println(result);
    }

}
