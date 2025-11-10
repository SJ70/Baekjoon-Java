import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _28094 {

    private static int N;
    private static int M;

    private static int[][] getScore;

    private static int maxScore;
    private static int maxScoreCases;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            getScore = new int[N + 1][N + 1];
            for (int m=0; m<M; m++) {
                st = new StringTokenizer(br.readLine());
                int score = Integer.parseInt(st.nextToken());
                int left = Integer.parseInt(st.nextToken());
                int right = Integer.parseInt(st.nextToken());
                getScore[left][right] += score;
            }

            maxScore = 0;
            maxScoreCases = 0;
            boolean[] visited = new boolean[N + 1];
            dfs(visited, 0, 0);
            sb.append(maxScore);
            sb.append(" ");
            sb.append(maxScoreCases);
            sb.append("\n");
        }
        System.out.print(sb);
    }

    private static void dfs(boolean[] visited, int depth, int score) {
        if (depth == N) {
            if (maxScore < score) {
                maxScore = score;
                maxScoreCases = 0;
            }
            if (maxScore == score) {
                maxScoreCases++;
            }
            return;
        }
        for (int i=1; i<=N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                int newScore = score;
                for (int j=1; j<=N; j++) {
                    if (!visited[j]) {
                        newScore += getScore[i][j];
                    }
                }
                dfs(visited, depth + 1, newScore);
                visited[i] = false;
            }
        }
    }

}
