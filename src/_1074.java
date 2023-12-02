import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1074 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = (int) Math.pow(2, Integer.parseInt(st.nextToken()));
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        System.out.println(getResult(n, r, c));
    }

    private static int getResult(int n, int r, int c) {
        if (n == 1) {
            return 0;
        }
        int half = n / 2;
        if (r < half && c < half) {
            return getResult(half, r, c);
        }
        if (r < half && c >= half) {
            return half * half + getResult(half, r, c - half);
        }
        if (r >= half && c < half) {
            return 2 * half * half + getResult(half, r - half, c);
        }
        if (r >= half && c >= half) {
            return 3 * half * half + getResult(half, r - half, c - half);
        }
        throw new RuntimeException();
    }

}
