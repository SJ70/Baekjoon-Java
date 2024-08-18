import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _15720 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> bs = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> cs = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> ds = new PriorityQueue<>(Collections.reverseOrder());

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<B; i++) {
            bs.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<C; i++) {
            cs.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<D; i++) {
            ds.add(Integer.parseInt(st.nextToken()));
        }

        int result1 = 0;
        int result2 = 0;

        int setCnt = Math.min(B, Math.min(C, D));
        for (int i=0; i<setCnt; i++) {
            int b = bs.poll();
            int c = cs.poll();
            int d = ds.poll();
            int sum = b + c + d;
            result1 += sum;
            result2 += sum * 0.9;
        }

        while (!bs.isEmpty()) {
            int b = bs.poll();
            result1 += b;
            result2 += b;
        }
        while (!cs.isEmpty()) {
            int c = cs.poll();
            result1 += c;
            result2 += c;
        }
        while (!ds.isEmpty()) {
            int d = ds.poll();
            result1 += d;
            result2 += d;
        }
        System.out.println(result1);
        System.out.println(result2);

    }

}
