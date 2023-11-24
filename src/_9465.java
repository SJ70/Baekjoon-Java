import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _9465 {

    private static final int UP = 0;
    private static final int DOWN = 1;
    private static final int NOTHING = 2;

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            init();
            sb.append(getMaxValue()).append('\n');
        }
        System.out.print(sb);
    }

    private static int n;
    private static int[][] stickers;

    private static void init() throws IOException {
        n = Integer.parseInt(br.readLine());
        stickers = new int[2][n];

        for (int r = 0; r < 2; r++) {
            stickers[r] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
    }

    private static int getMaxValue() {
        int[][] select = new int[3][n];

        // 상태 1 : 위를 선택
        // 상태 2 : 아래를 선택
        // 상태 3 : 아무것도 선택하지 않음
        select[UP][0] = stickers[UP][0];
        select[DOWN][0] = stickers[DOWN][0];
        select[NOTHING][0] = 0;

        for (int i = 1; i < n; i++) {
            select[UP][i] = stickers[UP][i] + Math.max(select[DOWN][i-1], select[NOTHING][i-1]);
            select[DOWN][i] = stickers[DOWN][i] + Math.max(select[UP][i-1], select[NOTHING][i-1]);
            select[NOTHING][i] = triMax(select[UP][i-1], select[DOWN][i-1], select[NOTHING][i-1]);
        }

        return triMax(
                select[UP][n-1],
                select[DOWN][n-1],
                select[NOTHING][n-1]
        );
    }

    private static int triMax(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

}
