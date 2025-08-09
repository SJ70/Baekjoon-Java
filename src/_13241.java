import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _13241 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long tmp = Math.max(a, b);
        a = Math.min(a, b);
        b = tmp;
        long result = a * b / func(a, b);
        System.out.println(result);
    }

    private static long func(long a, long b) {
//        System.out.printf("%d %d\n", a, b);
        long tmp = b % a;
        if (tmp == 0) {
            return a;
        }
        return func(tmp, a);
    }

}
