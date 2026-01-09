import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _14620 {

    private static int N;
    private static int[][] price;
    private static boolean[][] used;
    private static int minResult;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        price = new int[N][N];
        used = new boolean[N][N];
        for (int i=0; i<N; i++) {
            price[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        minResult = Integer.MAX_VALUE;
        dfs(0, 0, 1, 1);
        System.out.println(minResult);
    }

    private static void dfs(int result, int depth, int r, int c) {
        if (c == N - 1) {
            r++;
            c = 1;
        }

        if (depth == 3) {
            minResult = Math.min(minResult, result);
            return;
        }
        if (r == N - 1) {
            return;
        }
        if (!used[r-1][c] && !used[r][c-1] && !used[r+1][c] && !used[r][c+1] && !used[r][c]) {
            used[r][c] = used[r][c-1] = used[r][c+1] = used[r-1][c] = used[r+1][c] = true;
            dfs(result + price[r][c] + price[r-1][c] + price[r+1][c] + price[r][c-1] + price[r][c+1], depth + 1, r, c + 1);
            used[r][c] = used[r][c-1] = used[r][c+1] = used[r-1][c] = used[r+1][c] = false;
        }
        dfs(result, depth, r, c + 1);
    }

}
