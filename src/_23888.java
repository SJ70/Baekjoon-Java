import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _23888 {

    private static long a, d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Long.parseLong(st.nextToken());
        d = Long.parseLong(st.nextToken());
        long gcd = gcd(a, d);
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int q = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            switch (q) {
                case 1 :
                    long length = r - l + 1;
                    long result = a * length + (l - 1 + r - 1) * length * d / 2;
                    sb.append(result);
                    break;
                case 2 :
                    if (l == r) {
                        sb.append(a + ((l - 1) * d));
                    }
                    else {
                        sb.append(gcd);
                    }
                    break;
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    private static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

}
