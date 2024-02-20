import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _15703 {

    private static PriorityQueue<Integer> pq = new PriorityQueue<>();
    private static PriorityQueue<Integer> nextPq = new PriorityQueue<>();

    private static int towersCnt = 0;
    private static int currentTowerHeight = 0;

    public static void main(String[] args) throws IOException {

        input();

        while (!pq.isEmpty()) {
            int value = pq.poll();

            // 쌓을 수 있다면 쌓고
            if (currentTowerHeight <= value) {
                currentTowerHeight++;
            }
            // 없다면 미뤄둔다
            else {
                nextPq.add(value);
            }

            // 더 쌓을 수 없다면 현재 쌓던 탑을 완성 처리
            if (pq.isEmpty()) {
                currentTowerHeight = 0;
                towersCnt++;

                // 아직 안 쌓은 주사위가 있다면 다시 쌓기
                if (!nextPq.isEmpty()) {
                    pq = nextPq;
                    nextPq = new PriorityQueue<>();
                }
            }
        }

        System.out.println(towersCnt);

    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            pq.add(Integer.parseInt(st.nextToken()));
        }
    }

}
