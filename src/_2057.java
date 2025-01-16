import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class _2057 {

    private static long N;
    private static List<Long> values = new ArrayList<>();
    private static boolean foundAnswer = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Long.parseLong(br.readLine());
        if (N == 0) {
            System.out.println("NO");
            return;
        }

        long value = 1;
        values.add(value);
        for (long i=1; true; i++) {
            value *= i;
            if (value > 1000000000000000000L) {
                break;
            }
            values.add(value);
        }

        dfs(0, 0);

        System.out.println(foundAnswer ? "YES" : "NO");
    }

    private static void dfs(int idx, long value) {
        if (value == N) {
            foundAnswer = true;
            return;
        }
        if (foundAnswer) {
            return;
        }
        if (idx == values.size()) {
            return;
        }
        dfs(idx + 1, value + values.get(idx));
        dfs(idx + 1, value);
    }

}
