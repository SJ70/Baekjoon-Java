import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2253 {

    private static int N;
    private static int M;
    private static boolean[] cantGo;
    private static Integer[][] minMoveCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cantGo = new boolean[N + 1];
        for (int i=0; i<M; i++) {
            int value = Integer.parseInt(br.readLine());
            cantGo[value] = true;
        }

        minMoveCount = new Integer[N + 1][201];
        if (!cantGo[2]) {
            minMoveCount[2][1] = 1;
        }

        for (int i=2; i<N; i++) {
            for (int j=1; j<=200; j++) {
                if (minMoveCount[i][j] == null) {
                    continue;
                }

                if (j-1 >= 1 && i+j-1 <= N && !cantGo[i+j-1] && (minMoveCount[i+j-1][j-1] == null || minMoveCount[i+j-1][j-1] > minMoveCount[i][j] + 1)) {
                    minMoveCount[i+j-1][j-1] = minMoveCount[i][j] + 1;
                }

                if (i+j <= N && !cantGo[i+j] && (minMoveCount[i+j][j] == null || minMoveCount[i+j][j] > minMoveCount[i][j] + 1)) {
                    minMoveCount[i+j][j] = minMoveCount[i][j] + 1;
                }

                if (j+1 <= 200 && i+j+1 <= N && !cantGo[i+j+1] && (minMoveCount[i+j+1][j+1] == null || minMoveCount[i+j+1][j+1] > minMoveCount[i][j] + 1)) {
                    minMoveCount[i+j+1][j+1] = minMoveCount[i][j] + 1;
                }

            }
        }

        int result = Integer.MAX_VALUE;
        for (int j=1; j<=200; j++) {
            if (minMoveCount[N][j] != null) {
                result = Math.min(result, minMoveCount[N][j]);
            }
        }
        System.out.println(result == Integer.MAX_VALUE ? -1 : result);

    }

}
