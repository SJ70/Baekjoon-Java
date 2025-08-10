import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1735 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int e = a * d + c * b;
        int f = b * d;
        int g = func(Math.min(e, f), Math.max(e, f));
        System.out.printf("%d %d\n", e/g, f/g);
    }

    private static int func(int a, int b) {
        int v = b % a;
        if (v == 0) {
            return a;
        }
        else return func(v, a);
    }

}
