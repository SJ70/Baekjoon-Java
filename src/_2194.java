import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2194 {

    private static int height;
    private static int width;
    private static int unitHeight;
    private static int unitWidth;
    private static int wallCount;
    private static boolean[][] isWall;

    private static int[][] prefixWallCount;

    private static int compressedHeight;
    private static int compressedWidth;
    private static boolean[][] canVisit;

    private static int startR;
    private static int startC;
    private static int endR;
    private static int endC;

    private static int[] dr = {0, 1, 0, -1};
    private static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        input();
        compress();
        System.out.println(bfs());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());
        unitHeight = Integer.parseInt(st.nextToken());
        unitWidth = Integer.parseInt(st.nextToken());
        wallCount = Integer.parseInt(st.nextToken());

        isWall = new boolean[height][width];
        for (int i = 0; i < wallCount; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            isWall[r][c] = true;
        }

        st = new StringTokenizer(br.readLine());
        startR = Integer.parseInt(st.nextToken()) - 1;
        startC = Integer.parseInt(st.nextToken()) - 1;

        st = new StringTokenizer(br.readLine());
        endR = Integer.parseInt(st.nextToken()) - 1;
        endC = Integer.parseInt(st.nextToken()) - 1;
    }

    private static void compress() {
        // prefix
        prefixWallCount = new int[height + 1][width + 1];
        for (int r = 1; r <= height; r++) {
            for (int c = 1; c <= width; c++) {
                int isWallValue = isWall[r - 1][c - 1] ? 1 : 0;
                prefixWallCount[r][c] = isWallValue + prefixWallCount[r - 1][c];
            }
        }
        for (int r = 1; r <= height; r++) {
            for (int c = 1; c <= width; c++) {
                prefixWallCount[r][c] += prefixWallCount[r][c - 1];
//                System.out.print(prefixWallCount[r][c]);
            }
//            System.out.println();
        }
//        System.out.println();

        // compress
        compressedHeight = height - unitHeight + 1;
        compressedWidth = width - unitWidth + 1;
        canVisit = new boolean[compressedHeight][compressedWidth];

        for (int r = 0; r < compressedHeight; r++) {
            for (int c = 0; c < compressedWidth; c++) {
                canVisit[r][c] = canUnitVisit(r + 1, c + 1);
//                System.out.print(canVisit[r][c] ? '.' : '#');
            }
//            System.out.println();
        }
//        System.out.println();
    }

    private static boolean canUnitVisit(int r, int c) {
        int entire = prefixWallCount[r + unitHeight - 1][c + unitWidth - 1];
        int exceptLeft = prefixWallCount[r - 1][c + unitWidth - 1];
        int exceptUp = prefixWallCount[r + unitHeight - 1][c - 1];
        int containExceptedTwice = prefixWallCount[r - 1][c - 1];
        int wallCount = entire - exceptUp - exceptLeft + containExceptedTwice;
        return wallCount == 0;
    }

    private static int bfs() {
        Queue<Integer> qr = new ArrayDeque<>();
        Queue<Integer> qc = new ArrayDeque<>();

        qr.add(startR);
        qc.add(startC);
        canVisit[startR][startC] = false;

        int time = 0;
        while (!qr.isEmpty()) {

            int thisTimeQueueSize = qr.size();
            for (int i = 0; i < thisTimeQueueSize; i++) {

                int r = qr.poll();
                int c = qc.poll();

                // isArrived
                if (r == endR && c == endC) {
                    return time;
                }

                // addQueue
                for (int dir = 0; dir < 4; dir++) {
                    int nextR = r + dr[dir];
                    int nextC = c + dc[dir];
                    if (nextR >= 0 && nextR < compressedHeight && nextC >= 0 && nextC < compressedWidth && canVisit[nextR][nextC]) {
                        qr.add(nextR);
                        qc.add(nextC);
                        canVisit[nextR][nextC] = false;
                    }
                }

            }
            time++;
        }

        return -1;
    }

}
