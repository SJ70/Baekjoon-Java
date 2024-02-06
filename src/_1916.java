import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _1916 {

    private static int cityCnt;
    private static int busCnt;
    private static List<List<Node>> roots = new ArrayList<>();
    private static int startingPoint;
    private static int destination;

    private static final int INF = Integer.MAX_VALUE;

    private static int[] costs;
    private static boolean[] visited;

    private static class Node {
        int index;
        int cost;

        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        public String toString() {
            return String.format("( -> %d : %d )", index, cost);
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        dijkstra();
        System.out.println(costs[destination]);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        cityCnt = Integer.parseInt(br.readLine());
        busCnt = Integer.parseInt(br.readLine());

        roots = Stream.generate(() -> new ArrayList<Node>()).limit(cityCnt + 1).collect(Collectors.toList());
        for (int i = 0; i < busCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            roots.get(from).add(new Node(to, cost));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        startingPoint = Integer.parseInt(st.nextToken());
        destination = Integer.parseInt(st.nextToken());
    }

    private static void dijkstra() {
        costs = new int[cityCnt + 1];
        for (int i=1; i<=cityCnt; i++) {
            costs[i] = INF;
        }

        visited = new boolean[cityCnt + 1];

        costs[startingPoint] = 0;

        for (int i=0; i<cityCnt; i++) {
            visit(getMinDistanceUnvisitedCityIndex());
        }
    }

    private static int getMinDistanceUnvisitedCityIndex() {
        int minDistUnvisitedCityIndex = 0;
        int minDistUnvisitedCityDist = Integer.MAX_VALUE;

        for (int i=1; i<=cityCnt; i++) {
            if (visited[i]) {
                continue;
            }
            if (minDistUnvisitedCityDist > costs[i]) {
                minDistUnvisitedCityIndex = i;
                minDistUnvisitedCityDist = costs[i];
            }
        }
        return minDistUnvisitedCityIndex;
    }

    private static void visit(int from) {
        visited[from] = true;

        for (Node root : roots.get(from)) {
            int to = root.index;
            int entireCost = root.cost + costs[from];
            if (costs[to] > entireCost) {
                costs[to] = entireCost;
            }

        }
    }

}
