import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1359 {

    private static int n;
    private static int m;
    private static int k;

    private static boolean[] selected;

    private static double successCaseCount = 0;
    private static double entireCaseCount = 0;

    public static void main(String[] args) throws IOException {
        input();
        selected = new boolean[n];
        dfs(0,0);
        System.out.println(successCaseCount / entireCaseCount);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
    }

    private static void dfs(int number, int count) {
        if (count == m) {
            int same = 0;
            for (int i=0; i<m; i++) {
                if (selected[i]) {
                    same++;
                }
            }
            if (same >= k) {
                successCaseCount++;
            }
            entireCaseCount++;
            return;
        }

        for (int i = number; i < n; i++) {
            selected[i] = true;
            dfs(i + 1, count + 1);
            selected[i] = false;
        }
    }

}
