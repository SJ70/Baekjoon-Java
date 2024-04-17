import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _16173 {

    private static int N;
    private static int[][] arr;
    private static boolean[][] canGo;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        canGo = new boolean[N][N];

        for (int r=0; r<N; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c=0; c<N; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        canGo[0][0] = true;

        for (int r=0; r<N; r++) {
            for (int c=0; c<N; c++) {
                if (!canGo[r][c]) {
                    continue;
                }
                int value = arr[r][c];
                if (r + value < N) {
                    canGo[r + value][c] = true;
                }
                if (c + value < N) {
                    canGo[r][c + value] = true;
                }
            }
        }

        System.out.println(canGo[N-1][N-1] ? "HaruHaru" : "Hing");

    }

}
