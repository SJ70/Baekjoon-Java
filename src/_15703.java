import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class _15703 {

    private static Queue<Integer> q = new PriorityQueue<>();
    private static Queue<Integer> nextQ = new ArrayDeque<>();

    private static int towersCnt = 0;
    private static int currentTowerHeight = 0;

    public static void main(String[] args) throws IOException {

        input();

        while (true) {

            while (!q.isEmpty()) {
                int value = q.poll();

                // 쌓을 수 있다면 쌓고
                if (currentTowerHeight <= value) {
                    currentTowerHeight++;
                }
                // 없다면 미뤄둔다
                else {
                    nextQ.add(value);
                }
            }

            // 더 쌓을 수 주사위가 없다면 현재 쌓던 탑을 완성 처리
            currentTowerHeight = 0;
            towersCnt++;

            if (nextQ.isEmpty()) {
                break;
            }
            // 미뤄둔 주사위가 있다면 다시 쌓기
            q = nextQ;
            nextQ = new ArrayDeque<>();
        }

        System.out.println(towersCnt);

    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            q.add(Integer.parseInt(st.nextToken()));
        }
    }

}
