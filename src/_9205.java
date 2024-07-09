import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class _9205 {

    private static class Node {
        int x, y;
        boolean visited = false;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void visit() {
            this.visited = true;
        }

        public boolean canGo(Node node) {
            return getDistance(node) <= 1000;
        }

        public int getDistance(Node node) {
            return Math.abs(x - node.x) + Math.abs(y - node.y);
        }

    }

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();

    private static List<Node> shops;
    private static Node start, end;

    private static Queue<Node> nodes;

    public static void main(String[] args) throws IOException {

        int T = Integer.parseInt(br.readLine());
        for (int t=0; t<T; t++) {
            sb.append(canGo() ? "happy\n" : "sad\n");
        }
        System.out.print(sb);

    }

    private static boolean canGo() throws IOException {
        shops = new ArrayList<>();
        nodes = new ArrayDeque<>();

        input();
        nodes.add(start);
        while (!nodes.isEmpty()) {
            Node node = nodes.poll();
            if (node.canGo(end)) {
                return true;
            }
            for (Node shop : shops) {
                if (!shop.visited && node.canGo(shop)) {
                    nodes.add(shop);
                    shop.visit();
                }
            }
        }
        return false;
    }

    private static void input() throws IOException {
        int N = Integer.parseInt(br.readLine());
        start = inputNode();
        for (int i=0; i<N; i++) {
            shops.add(inputNode());
        }
        end = inputNode();
    }

    private static Node inputNode() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        return new Node(r, c);
    }

}
