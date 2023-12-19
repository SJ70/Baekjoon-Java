import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14391 {

    private static int R, C;
    private static int[][] numbers;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(cut(numbers));
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        numbers = new int[R][C];
        for (int r = 0; r < R; r++) {
            char[] chars = br.readLine().toCharArray();
            for (int c = 0; c < C; c++) {
                numbers[r][c] = chars[c] - '0';
            }
        }
    }

    private static int cut(int[][] nums) {
        if (nums.length == 1 || nums[0].length == 1) {
            return getNum(nums);
        }
        return Math.max(
                Math.max(
                        cutLeft(nums), cutRight(nums)
                ),
                Math.max(
                        cutTop(nums), cutBottom(nums)
                )
        );
    }

    // 세로/가로 한 줄일 때 사용
    private static int getNum(int[][] nums) {
        int r = nums.length;
        int c = nums[0].length;
        int num = 0;
        for (int depth = 0; depth < r * c; depth++) {
            int row = depth / c;
            int col = depth % c;
            num *= 10;
            num += nums[row][col];
        }
        return num;
    }

    private static int cutLeft(int[][] nums) {
        int r = nums.length;
        int c = nums[0].length;

        int[][] cutNums = new int[r][c - 1];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c - 1; j++) {
                cutNums[i][j] = nums[i][j + 1];
            }
        }

        int cutNum = 0;
        for (int i = 0; i < r; i++) {
            cutNum *= 10;
            cutNum += nums[i][0];
        }

        return cutNum + cut(cutNums);
    }

    private static int cutRight(int[][] nums) {
        int r = nums.length;
        int c = nums[0].length;

        int[][] cutNums = new int[r][c - 1];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c - 1; j++) {
                cutNums[i][j] = nums[i][j];
            }
        }

        int cutNum = 0;
        for (int i = 0; i < r; i++) {
            cutNum *= 10;
            cutNum += nums[i][c - 1];
        }

        return cutNum + cut(cutNums);
    }

    private static int cutTop(int[][] nums) {
        int r = nums.length;
        int c = nums[0].length;

        int[][] cutNums = new int[r - 1][c];
        for (int i = 0; i < r - 1; i++) {
            for (int j = 0; j < c; j++) {
                cutNums[i][j] = nums[i + 1][j];
            }
        }

        int cutNum = 0;
        for (int i = 0; i < c; i++) {
            cutNum *= 10;
            cutNum += nums[0][i];
        }

        return cutNum + cut(cutNums);
    }

    private static int cutBottom(int[][] nums) {
        int r = nums.length;
        int c = nums[0].length;

        int[][] cutNums = new int[r - 1][c];
        for (int i = 0; i < r - 1; i++) {
            for (int j = 0; j < c; j++) {
                cutNums[i][j] = nums[i][j];
            }
        }

        int cutNum = 0;
        for (int i = 0; i < c; i++) {
            cutNum *= 10;
            cutNum += nums[r - 1][i];
        }

        return cutNum + cut(cutNums);
    }

}
