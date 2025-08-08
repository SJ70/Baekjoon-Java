import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _22993 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long dmg = Long.parseLong(st.nextToken());
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int i=0; i<N-1; i++) {
            long enemyDmg = Long.parseLong(st.nextToken());
            if (dmg > enemyDmg) {
                dmg += enemyDmg;
            }
            else {
                pq.add(enemyDmg);
            }
        }
        while (!pq.isEmpty()) {
            long enemyDmg = pq.poll();
            if (dmg > enemyDmg) {
                dmg += enemyDmg;
            }
            else {
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }

}
