import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class _5014 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());
        int up = Integer.parseInt(st.nextToken());
        int down = Integer.parseInt(st.nextToken());
        int[] adds = {up, -down};

        boolean[] visited = new boolean[N+1];
        visited[from] = true;

        Queue<Integer> q = new ArrayDeque<>();
        q.add(from);

        for (int time=0; !q.isEmpty(); time++) {

            int loopCnt = q.size();
            for (int i=0; i<loopCnt; i++) {

                int current = q.poll();
                if (current == to) {
                    System.out.println(time);
                    return;
                }

                for (int add : adds) {
                    int next = current + add;
                    if (next < 1 || next > N || visited[next]) {
                        continue;
                    }
                    visited[next] = true;
                    q.add(next);
                }
            }
        }
        System.out.println("use the stairs");
    }

}
