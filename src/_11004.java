import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _11004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        PriorityQueue<Integer> numbers = new PriorityQueue<>();

        for (int i=0; i<n; i++) {
            int number = Integer.parseInt(st.nextToken());
            numbers.add(number);
        }

        for (int i=0; i<k-1; i++) {
            numbers.poll();
        }

        int result = numbers.poll();
        System.out.println(result);
    }
}
