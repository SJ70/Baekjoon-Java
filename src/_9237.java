import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class _9237 {

    private static Queue<Integer> saplingGrowingTimes = new PriorityQueue<>(Collections.reverseOrder());

    public static void main(String[] args) throws IOException {
        input();
        int daysAllSaplingsGrowUp = 0;
        int day = 1;
        while (!saplingGrowingTimes.isEmpty()) {
            int saplingGrowingTime = saplingGrowingTimes.poll();
            daysAllSaplingsGrowUp = Math.max(saplingGrowingTime + day, daysAllSaplingsGrowUp);
            day++;
        }
        System.out.println(daysAllSaplingsGrowUp + 1);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int treeCount = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            int saplingGrowingTime = Integer.parseInt(st.nextToken());
            saplingGrowingTimes.add(saplingGrowingTime);
        }
    }

}
