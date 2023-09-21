import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _20125 {

    private static int boardSize;
    private static boolean[][] isBody;

    private static class Pair {
        private final int r, c;
        public Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
        public int getR() {
            return this.r;
        }
        public int getC() {
            return this.c;
        }
    }

    private static final Pair DIR_LEFT = new Pair(0, -1);
    private static final Pair DIR_RIGHT = new Pair(0, 1);
    private static final Pair DIR_DOWN = new Pair(1, 0);

    public static void main(String[] args) throws IOException {

        input();

        Pair heartCoordinate = findHeartCoordinate();
        int heartR = heartCoordinate.getR();
        int heartC = heartCoordinate.getC();

        Pair leftArmStartCoordinate = new Pair(heartR, heartC-1);
        Pair rightArmStartCoordinate = new Pair(heartR, heartC+1);

        int leftArmLength = observeLength(leftArmStartCoordinate, DIR_LEFT);
        int rightArmLength = observeLength(rightArmStartCoordinate, DIR_RIGHT);

        int waistStartR = heartR+1;
        Pair waistStartCoordinate = new Pair(waistStartR, heartC);
        int waistLength = observeLength(waistStartCoordinate, DIR_DOWN);
        int waistEndR = waistStartR + waistLength - 1;

        Pair leftLegStartCoordinate = new Pair(waistEndR+1, heartC-1);
        Pair rightLegStartCoordinate = new Pair(waistEndR+1, heartC+1);

        int leftLegLength = observeLength(leftLegStartCoordinate, DIR_DOWN);
        int rightLegLength = observeLength(rightLegStartCoordinate, DIR_DOWN);

        System.out.printf("%d %d\n%d %d %d %d %d\n", heartR+1, heartC+1, leftArmLength, rightArmLength, waistLength, leftLegLength, rightLegLength);

    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boardSize = Integer.parseInt(br.readLine());
        isBody = new boolean[boardSize][boardSize];

        for (int r=0; r<boardSize; r++) {
            String input = br.readLine();
            for (int c=0; c<boardSize; c++) {
                isBody[r][c] = input.charAt(c) == '*';
            }
        }
    }

    private static Pair findHeartCoordinate() {
        for (int r=1; r<boardSize - 1; r++) {
            for (int c=1; c<boardSize - 1; c++) {
                if (isBody[r-1][c] && isBody[r+1][c] && isBody[r][c-1] && isBody[r][c+1]) {
                    return new Pair(r,c);
                }
            }
        }
        throw new IllegalStateException("따뜻한 심장을 가지지 못했습니다.");
    }

    private static int observeLength(Pair startingCoordinate, Pair direction) {
        int startR = startingCoordinate.getR();
        int startC = startingCoordinate.getC();
        int dirR = direction.getR();
        int dirC = direction.getC();

        int length = 0;

        int r = startR;
        int c = startC;
        while (r>=0 && r<boardSize && c>=0 && c<boardSize && isBody[r][c]) {
            r+=dirR;
            c+=dirC;
            length++;
        }

        return length;
    }
}
