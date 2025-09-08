import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _24542 {

    private static int N;
    private static List<Integer>[] children;
    private static boolean[] visited;
    private static int counter;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        children = new List[N + 1];
        for (int i=1; i<=N; i++) {
            children[i] = new ArrayList<>();
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            children[a].add(b);
            children[b].add(a);
        }

        long result = 1;
        visited = new boolean[N + 1];
        for (int i=1; i<=N; i++) {
            if (!visited[i]) {
                counter = 0;
                visit(i);
                result *= counter;
                result %= 1000000007;
            }
        }
        System.out.println(result);
    }

    private static void visit(int i) {
        if (visited[i]) {
            return;
        }
        counter++;
        visited[i] = true;
        for (int j : children[i]) {
            visit(j);
        }
    }

}
