import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _20057 {

    private static final int[] DR = {0, -1, 0, 1};
    private static final int[] DC = {-1, 0, 1, 0};

    private static int n;
    private static int[][] amountsOfSand;
    private static boolean[][] windVisited;
    private static int amountOfSandOutOfRange;

    public static void main(String[] args) throws IOException {
        init();
        windFrom(0, 0, 0);
        System.out.println(amountOfSandOutOfRange);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        amountsOfSand = new int[n][n];
        for (int i=0; i<n; i++) {
            amountsOfSand[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        windVisited = new boolean[n][n];
    }

    private static void windFrom(int r, int c, int dir) {
//        printAmountsOfSand();
//        printWindVisited();

        windVisited[r][c] = true;

        if (r != n / 2 || c != n / 2) {
            int preR = r - DR[dir];
            int preC = c - DC[dir];
            int preDir = dir;
            if (isOutOfRange(preR, preC) || windVisited[preR][preC]) {
                preDir = (dir + 1) % 4;
                preR = r - DR[preDir];
                preC = c - DC[preDir];
            }
            windFrom(preR, preC, preDir);
        }

        if (!isOutOfRange(r + DR[dir], c + DC[dir])) {
            spreadSandFrom(r + DR[dir], c + DC[dir], dir);
        }
    }

    private static void spreadSandFrom(int r, int c, int dir) {
//        System.out.printf("%d %d %d\n",r,c,dir);
        int amountOfSand = amountsOfSand[r][c];
        int front = dir;
        amountOfSand -= spreadSandTo(r + DR[front] * 2, c + DC[front] * 2, (int) (amountsOfSand[r][c] * 0.05) );

        int side1 = (dir + 1) % 4;
        amountOfSand -= spreadSandTo(r + DR[side1], c + DC[side1], (int) (amountsOfSand[r][c] * 0.07) );
        amountOfSand -= spreadSandTo(r + DR[side1] * 2, c + DC[side1] * 2, (int) (amountsOfSand[r][c] * 0.02) );

        int side2 = (dir + 3) % 4;
        amountOfSand -= spreadSandTo(r + DR[side2], c + DC[side2], (int) (amountsOfSand[r][c] * 0.07) );
        amountOfSand -= spreadSandTo(r + DR[side2] * 2, c + DC[side2] * 2, (int) (amountsOfSand[r][c] * 0.02) );

        amountOfSand -= spreadSandTo(r + DR[front] + DR[side1], c + DC[front] + DC[side1], (int) (amountsOfSand[r][c] * 0.1) );
        amountOfSand -= spreadSandTo(r + DR[front] + DR[side2], c + DC[front] + DC[side2], (int) (amountsOfSand[r][c] * 0.1) );

        int back = (dir + 2) % 4;
        amountOfSand -= spreadSandTo(r + DR[back] + DR[side1], c + DC[back] + DC[side1], (int) (amountsOfSand[r][c] * 0.01) );
        amountOfSand -= spreadSandTo(r + DR[back] + DR[side2], c + DC[back] + DC[side2], (int) (amountsOfSand[r][c] * 0.01) );

        spreadSandTo(r + DR[front], c + DC[front], amountOfSand);

        amountsOfSand[r][c] = 0;
    }

    private static int spreadSandTo(int r, int c, int amount) {
        if (isOutOfRange(r, c)) {
            amountOfSandOutOfRange += amount;
        }
        else {
            amountsOfSand[r][c] += amount;
        }
        return amount;
    }

    private static boolean isOutOfRange(int r, int c) {
        return r < 0 || r >= n || c < 0 || c >= n;
    }

    private static void printAmountsOfSand() {
        for (int r=0; r<n; r++) {
            for (int c=0; c<n; c++) {
                System.out.printf("%3d",amountsOfSand[r][c]);
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void printWindVisited() {
        for (int r=0; r<n; r++) {
            for (int c=0; c<n; c++) {
                System.out.printf("%3d",windVisited[r][c] ? 1 : 0);
            }
            System.out.println();
        }
        System.out.println();
    }

}
