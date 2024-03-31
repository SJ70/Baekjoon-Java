import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _16435 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int snakeBirdLength = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> fruitsHeight = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            fruitsHeight.add(Integer.parseInt(st.nextToken()));
        }

        for (; !fruitsHeight.isEmpty() && snakeBirdLength >= fruitsHeight.poll(); snakeBirdLength++);

        System.out.println(snakeBirdLength);
    }

}
