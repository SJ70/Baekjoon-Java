import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _11725 {

    private static int N;
    private static List<Integer>[] nodes;
    private static boolean[] nodeVisited;
    private static int[] parents;

    public static void main(String[] args) throws IOException {

        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        nodes = new List[N + 1];
        for (int i=0; i<=N; i++) {
            nodes[i] = new ArrayList<>();
        }
        for (int i=0; i<N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            nodes[from].add(to);
            nodes[to].add(from);
        }

        // dfs
        nodeVisited = new boolean[N + 1];
        parents = new int[N + 1];
        setChildrenParent(1);

        // result
        StringBuilder sb = new StringBuilder();
        for (int i=2; i<=N; i++) {
            sb.append(parents[i]);
            sb.append('\n');
        }
        System.out.print(sb);
    }

    private static void setChildrenParent(int idx) {
        nodeVisited[idx] = true;

        for (int node : nodes[idx]) {

            if (!nodeVisited[node]) {
                parents[node] = idx;
                setChildrenParent(node);
            }
        }
    }

}
