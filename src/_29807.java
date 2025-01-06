import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _29807 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a, b, c, d, e;
        a = b = c = d = e = 0;
        if (st.hasMoreTokens()) {
            a = Integer.parseInt(st.nextToken());
        }
        if (st.hasMoreTokens()) {
            b = Integer.parseInt(st.nextToken());
        }
        if (st.hasMoreTokens()) {
            c = Integer.parseInt(st.nextToken());
        }
        if (st.hasMoreTokens()) {
            d = Integer.parseInt(st.nextToken());
        }
        if (st.hasMoreTokens()) {
            e = Integer.parseInt(st.nextToken());
        }
        int result = 0;
        result += Math.abs((a - c)) * ((a > c) ? 508 : 108);
        result += Math.abs((b - d)) * ((b > d) ? 212 : 305);
        result += e * 707;
        result *= 4763;
        System.out.println(result);
    }

}
