import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _31962 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int lastArriveTime = -1;
        int result = -1;

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            int arrive = from + time;
            if (arrive <= X && arrive >= lastArriveTime) {
                result = Math.max(from, result);
            }
        }
        System.out.println(result);
    }

}
