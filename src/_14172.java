import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _14172 {

    private static Cow[] cows;
    private static boolean[] visited;
    private static int maxResult = -1;
    private static int result;

    private static class Cow {
        int x, y, dist;
        List<Integer> reachableIdx = new ArrayList<>();

        public Cow (int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        public void tryReach(int idx) {
            if (canReach(cows[idx])) {
                reachableIdx.add(idx);
            }
        }

        public boolean canReach(Cow cow) {
            return Math.pow(dist, 2) >= Math.pow(x-cow.x, 2) + Math.pow(y-cow.y, 2);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        cows = new Cow[N];
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            Cow cow = new Cow(x, y, dist);
            cows[i] = cow;
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                cows[i].tryReach(j);
            }
        }

        for (int i=0; i<N; i++) {
            visited = new boolean[N];
            result = 0;
            visit(i);
            maxResult = Math.max(maxResult, result);
        }

        System.out.println(maxResult);

    }

    private static void visit(int idx) {
        result++;
        visited[idx] = true;
        for (int i : cows[idx].reachableIdx) {
            if (!visited[i]) {
                visit(i);
            }
        }
    }

}
