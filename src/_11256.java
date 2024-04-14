import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _11256 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t=0; t<T; t++) {
            StringTokenizer st;
            st = new StringTokenizer(br.readLine());

            int candyCnt = Integer.parseInt(st.nextToken());
            int boxCnt = Integer.parseInt(st.nextToken());
            int requiredBoxCnt = 0;

            PriorityQueue<Integer> boxes = new PriorityQueue<>(Collections.reverseOrder());
            for (int i=0; i<boxCnt; i++) {
                st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int area = r * c;
                boxes.add(area);
            }

            while (!boxes.isEmpty() && candyCnt > 0) {
                candyCnt -= boxes.poll();
                requiredBoxCnt++;
            }

            sb.append(requiredBoxCnt).append('\n');
        }

        System.out.print(sb);

    }

}
