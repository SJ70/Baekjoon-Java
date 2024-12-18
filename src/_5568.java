import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class _5568 {

    private static int N, K;
    private static String[] arr;
    private static Set<String> results = new HashSet<>();
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        arr = new String[N];
        visited = new boolean[N];
        for (int i=0; i<N; i++) {
            arr[i] = br.readLine();
        }
        dfs(0, "", 0);
//        System.out.println(results.toString());
        System.out.println(results.size());
    }

    private static void dfs(int idx, String value, int cnt) {
        if (cnt == K) {
            results.add(value);
            return;
        }
        if (idx == N) {
            return;
        }
        if (!visited[idx]) {
            visited[idx] = true;
            dfs(0, value + arr[idx], cnt + 1);
            visited[idx] = false;
        }
        dfs(idx + 1, value, cnt);
    }

}
