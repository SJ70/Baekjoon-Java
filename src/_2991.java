import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2991 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<3; i++) {
            int p = Integer.parseInt(st.nextToken());
            int p1 = p % (a + b);
            int p2 = p % (c + d);
            int result = 0;
            if (p1 > 0 && p1 <= a) {
                result ++;
            }
            if (p2 > 0 && p2 <= c) {
                result ++;
            }
            System.out.println(result);
        }
    }

}
