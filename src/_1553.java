import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1553 {

    private static final int R = 8;
    private static final int C = 7;
    private static final int N = 7;

    private static int[][] numbers = new int[R][C];
    private static boolean[][] isFilled = new boolean[R][C];
    private static boolean[][] isUsed = new boolean[N][N];

    private static int result = 0;

    public static void main(String[] args) throws IOException {
        input();
        dfs(0,0);
        System.out.println(result);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int r=0; r<R; r++) {
            String nums = br.readLine();
            for (int c=0; c<C; c++) {
                numbers[r][c] = nums.charAt(c) - '0';
            }
        }
    }

    private static void dfs(int r, int c) {
        if (r == R) {
            result++;
            return;
        }

        if (isFilled[r][c]) {
            dfsNext(r, c);
            return;
        }

        int currentNum = numbers[r][c];

        if (c+1 < C) {
            int rightNum = numbers[r][c+1];
            int num1 = Math.min(currentNum, rightNum);
            int num2 = Math.max(currentNum, rightNum);
            if (!isUsed[num1][num2] && !isFilled[r][c+1]) {
                isUsed[num1][num2] = true;
                isFilled[r][c+1] = true;
                dfsNext(r, c);
                isUsed[num1][num2] = false;
                isFilled[r][c+1] = false;
            }
        }

        if (r+1 < R) {
            int underNum = numbers[r+1][c];
            int num1 = Math.min(currentNum, underNum);
            int num2 = Math.max(currentNum, underNum);
            if (!isUsed[num1][num2]) {
                isUsed[num1][num2] = true;
                isFilled[r+1][c] = true;
                dfsNext(r, c);
                isUsed[num1][num2] = false;
                isFilled[r+1][c] = false;
            }
        }
    }

    private static void dfsNext(int r, int c) {
        if (c+1 == C) {
            dfs(r+1, 0);
            return;
        }
        dfs(r, c+1);
    }

}
