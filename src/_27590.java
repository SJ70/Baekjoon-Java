import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _27590 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int ds = Integer.parseInt(st.nextToken());
        int ys = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int dm = Integer.parseInt(st.nextToken());
        int ym = Integer.parseInt(st.nextToken());

        for (int i=0; true; i++) {
            if (ds == 0 && dm == 0) {
                System.out.println(i);
                return;
            }
            ds++;
            ds %= ys;
            dm++;
            dm %= ym;
        }
    }

}
