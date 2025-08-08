import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _24313 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a1 = Integer.parseInt(st.nextToken());
        int a0 = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(br.readLine());
        int n0 = Integer.parseInt(br.readLine());
        boolean b1 = (a1 * n0 + a0) <= (c * n0);
        boolean b2 = ((a1 == c) && (a0 < 0)) || (a1 < c);
        System.out.println((b1 && b2) ? 1 : 0);
    }

}
