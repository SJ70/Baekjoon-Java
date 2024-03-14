import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _22955 {

    private static final int INF = Integer.MAX_VALUE;

    private static int R, C;
    private static char[][] values;

    private static int start, end;

    private static ArrayList<Node>[] nodes;

    private static PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
    private static int[] dists;

    private static class Node {
        int idx;
        int cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        switchToGraph();
        dijkstra();
        System.out.println(dists[end] == INF ? "dodo sad" : dists[end]);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        values = new char[R][C];
        for (int r=0; r<R; r++) {
            String str = br.readLine();
            for (int c=0; c<C; c++) {
                values[r][c] = str.charAt(c);
            }
        }
    }

    private static void switchToGraph() {
        nodes = new ArrayList[R * C];
        for (int i=0; i<R*C; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int r=0; r<R; r++) {
            for (int c=0; c<C; c++) {
                switch(values[r][c]) {
                    case 'C' :
                        start = getIndexOfCoordinate(r, c);
                        connectBesides(r, c);
                        break;
                    case 'L' :
                        connectLadder(r, c);
                        connectBesides(r, c);
                        break;
                    case 'F' :
                        connectBesides(r, c);
                        break;
                    case 'X' :
                        connectFall(r, c);
                        break;
                    case 'E' :
                        end = getIndexOfCoordinate(r, c);
                        break;
                    case 'D' :
                        break;
                }
            }
        }
    }

    private static void connectBesides(int r, int c) {
        int idx = getIndexOfCoordinate(r, c);
        if (c-1 >= 0 && values[r][c-1] != 'D') {
            nodes[idx].add(new Node(idx-1, 1));
        }
        if (c+1 < C && values[r][c+1] != 'D') {
            nodes[idx].add(new Node(idx+1, 1));
        }
    }

    private static void connectLadder(int r, int c) {
        int idx = getIndexOfCoordinate(r, c);
        if (r-1 >= 0 && values[r-1][c] != 'X' && values[r-1][c] != 'D') {
            nodes[idx].add(new Node(idx-C, 5));
            nodes[idx-C].add(new Node(idx, 5));
        }
    }

    private static void connectFall(int r, int c) {
        int fromIdx = getIndexOfCoordinate(r, c);
        while (values[++r][c] == 'X') {};
        if (values[r][c] == 'D') {
            return;
        }
        int toIdx = getIndexOfCoordinate(r, c);
        nodes[fromIdx].add(new Node(toIdx, 10));
    }

    private static int getIndexOfCoordinate(int r, int c) {
        return r * C + c;
    }

    private static void dijkstra() {
        dists = new int[R * C];
        Arrays.fill(dists, INF);

        pq.add(new Node(start, 0));
        dists[start] = 0;

        while(!pq.isEmpty()) {
            Node node = pq.poll();
//            System.out.printf("(%d,%d) : %d\n", node.idx/C, node.idx%C, node.cost);

            if (node.idx == end) {
                return;
            }

            if (dists[node.idx] < node.cost) {  // isVisitedAlready
                continue;
            }

            for (Node nextNode : nodes[node.idx]) {
                if (dists[nextNode.idx] > nextNode.cost + node.cost) {
                    dists[nextNode.idx] = nextNode.cost + node.cost;
//                    System.out.printf("  (%d,%d) : %d\n", nextNode.idx/C, nextNode.idx%C, dists[nextNode.idx]);
                    pq.add(new Node(nextNode.idx, dists[nextNode.idx]));
                }
            }
        }

    }

}
