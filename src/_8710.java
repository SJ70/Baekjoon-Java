import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _8710 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());
        int addPerHit = Integer.parseInt(st.nextToken());

        if (from >= to) {
            System.out.println(0);
            return;
        }
        System.out.println((int)Math.ceil((double)(to - from) / addPerHit));

    }

}
