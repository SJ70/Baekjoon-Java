import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class _13905 {

    private static int HOUSE_CNT, BRIDGE_CNT;
    private static int STARTING_POINT, DESTINATION;
    private static PriorityQueue<Bridge> bridges = new PriorityQueue<>((o1, o2) -> {return - o1.weight + o2.weight;});
    private static int[] unionFindArr;

    private static List<List<Bridge>> connectedBridges;

    private static Queue<Bridge> Q = new ArrayDeque();

    private static int result = 0;

    private static class Bridge {
        int from, to, weight;

        public Bridge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        public String toString() {
            return this.from + " -> " + this.to + " : " + this.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        setConnectedBridges();
//        System.out.println(connectedBridges);

        Q.add(new Bridge(-1, STARTING_POINT, Integer.MAX_VALUE));
        while(!Q.isEmpty()) {
            visit(Q.poll());
        }
        System.out.println(result);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        HOUSE_CNT = Integer.parseInt(st.nextToken());
        BRIDGE_CNT = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        STARTING_POINT = Integer.parseInt(st.nextToken());
        DESTINATION = Integer.parseInt(st.nextToken());

        for (int i=0; i<BRIDGE_CNT; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            bridges.add(new Bridge(from, to, weight));
        }

    }

    private static void setConnectedBridges() {
        connectedBridges = new ArrayList<>();
        for (int i=0; i<=HOUSE_CNT; i++) {
            connectedBridges.add(new ArrayList<>());
        }

        unionFindArr = new int[HOUSE_CNT + 1];
        for (int i=1; i<=HOUSE_CNT; i++) {
            unionFindArr[i] = i;
        }
        while (!bridges.isEmpty()) {
            Bridge bridge = bridges.poll();
//            System.out.println(bridge);
            int from = bridge.from;
            int to = bridge.to;
            int weight = bridge.weight;

            int fromParent = getUnionFindParent(from);
            int toParent = getUnionFindParent(to);
            if (fromParent == toParent) {
                continue;
            }
            unionFindArr[toParent] = fromParent;

            connectedBridges.get(from).add(bridge);
            connectedBridges.get(to).add(new Bridge(to, from, weight));
//            System.out.println(Arrays.stream(unionFindArr).mapToObj(String::valueOf).toList());
        }
    }

    private static int getUnionFindParent(int i) {
        int parent = unionFindArr[i];
        if (parent == i) {
            return i;
        }
        return unionFindArr[i] = getUnionFindParent(parent);
    }

    private static void visit(Bridge bridge) {
        int prev = bridge.from;
        int now = bridge.to;
        int weight = bridge.weight;
//        System.out.println(bridge);

        if (now == DESTINATION) {
            result = weight;
            Q.clear();
            return;
        }

        for (Bridge connectedBridge : connectedBridges.get(now)) {
            if (connectedBridge.to == prev) {
                continue;
            }
            weight = Math.min(weight, connectedBridge.weight);
            Q.add(new Bridge(now, connectedBridge.to, weight));
        }
    }

}
