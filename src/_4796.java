import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _4796 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 1; ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            if (l + p + v == 0) {
                break;
            }
            System.out.printf("Case %d: %d\n", i, getResult(l, p, v));
        }
    }

    private static int getResult(int l, int p, int v) {
        return v/p * l + Math.min(v%p, l);
    }

}
