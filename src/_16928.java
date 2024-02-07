import java.io.*;
import java.util.*;

public class _16928 {

    private static int[] jumpTo = new int[100];
    private static boolean[] visited = new boolean[100];
    private static Queue<Integer> q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        input();

        q.add(0);
        visited[0] = true;

        int jumpCnt = 0;
        while (!q.isEmpty()) {
            int repeat = q.size();
            jumpCnt++;
//                System.out.printf("\n---%d---\n",jumpCnt);
            for (int i = 0; i < repeat && !q.isEmpty(); i++) {
                bfs(q.poll());
            }
        }
        System.out.println(jumpCnt);
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            jumpTo[from] = to;
        }
    }

    public static void bfs(int i) {
//        System.out.println(i);
        for (int dice = 6; dice >= 1; dice--) {
            int next = i + dice;

            if (next == 99) {
                q.clear();
                return;
            }

            if (next >= 100) {
                continue;
            }

            if (jumpTo[next] != 0) {
                next = jumpTo[next];
            }

            if (!visited[next]) {
                visited[next] = true;
                q.add(next);
            }
        }
    }
}
