import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1934 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t=0; t<T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = func(Math.max(a, b), Math.min(a, b));
            sb.append((long) a * b /c);
            sb.append('\n');
        }
        System.out.print(sb);
    }

    private static int func(int a, int b) {
        int c = b % a;
        if (c == 0) {
            return a;
        }
        return func(c, a);
    }

}
