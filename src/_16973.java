import java.io.*;
import java.util.*;

public class _16973 {

    private static int boardHeight;
    private static int boardWidth;
    private static int rectHeight;
    private static int rectWidth;

    private static int startR;
    private static int startC;
    private static int destinationR;
    private static int destinationC;

    private static int[][] boardValue;

    private static int[][] prefixBoardValue;

    private static int compressedBoardHeight;
    private static int compressedBoardWidth;

    private static boolean[][] isWall;
    private static boolean[][] isVisited;
    private static Queue<int[]> q = new ArrayDeque<>();
    private static int[] dr = {0,1,0,-1};
    private static int[] dc = {1,0,-1,0};

    public static void main(String[] args) throws IOException {
        input();
        setPrefixBoardValue();
        compressBoard();

        int result = bfs();
        System.out.println(result);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        boardHeight = Integer.parseInt(st.nextToken());
        boardWidth = Integer.parseInt(st.nextToken());

        boardValue = new int[boardHeight][boardWidth];
        for (int r=0; r<boardHeight; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c=0; c<boardWidth; c++) {
                boardValue[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        rectHeight = Integer.parseInt(st.nextToken());
        rectWidth= Integer.parseInt(st.nextToken());
        startR = Integer.parseInt(st.nextToken()) - 1;
        startC = Integer.parseInt(st.nextToken()) - 1;
        destinationR = Integer.parseInt(st.nextToken()) - 1;
        destinationC = Integer.parseInt(st.nextToken()) - 1;
    }

    private static void setPrefixBoardValue() {
        prefixBoardValue = new int[boardHeight + 1][boardWidth + 1];
        for (int r=1; r<boardHeight; r++) {
            for (int c=1; c<=boardWidth; c++) {
                prefixBoardValue[r][c] = boardValue[r-1][c-1] + prefixBoardValue[r][c-1];
            }
        }

        for (int r=1; r<=boardHeight; r++) {
            for (int c=0; c<=boardWidth; c++) {
                prefixBoardValue[r][c] += prefixBoardValue[r-1][c];
            }
        }

//        for (int r=0; r<=boardHeight; r++) {
//            for (int c=0; c<=boardWidth; c++) {
//                System.out.printf("%3d",prefixBoardValue[r][c]);
//            }
//            System.out.println();
//        }
//        System.out.println();
    }

    private static void compressBoard() {

        compressedBoardHeight = boardHeight - rectHeight + 1;
        compressedBoardWidth = boardWidth - rectWidth + 1;

        isWall = new boolean[compressedBoardHeight][compressedBoardWidth];
        for (int r=0; r<compressedBoardHeight; r++) {
            for (int c=0; c<compressedBoardWidth; c++) {
                isWall[r][c] = isWall(r, c);
//                System.out.print(isWall[r][c] ? 1 : 0);
            }
//            System.out.println();
        }

    }

    private static boolean isWall(int fromR, int fromC) {
        int untilR = fromR + rectHeight - 1;
        int untilC = fromC + rectWidth - 1;
        int value = prefixBoardValue[untilR+1][untilC+1] - prefixBoardValue[untilR+1][fromC] - prefixBoardValue[fromR][untilC+1] + prefixBoardValue[fromR][fromC];
        return value > 0;
    }

    private static int bfs() {
        isVisited = new boolean[compressedBoardHeight][compressedBoardWidth];

        q.add(new int[] {startR, startC});
        isVisited[startR][startC] = true;

        int moveCount = 0;
        while (!q.isEmpty()) {
            int qSize = q.size();
            for (int i=0; i<qSize; i++) {
                int r = q.peek()[0];
                int c = q.poll()[1];

//                System.out.printf("%d, %d, time: %d \n", r,c,moveCount);

                if (r == destinationR && c == destinationC) {
                    return moveCount;
                }

                for (int dir=0; dir<4; dir++) {
                    int nextR = r + dr[dir];
                    int nextC = c + dc[dir];
                    if (nextR >= 0 && nextR < compressedBoardHeight && nextC >= 0 && nextC < compressedBoardWidth && !isVisited[nextR][nextC] && !isWall[nextR][nextC]) {
                        isVisited[nextR][nextC] = true;
                        q.add(new int[] {nextR, nextC});
                    }
                }
            }
            moveCount++;
        }

        return -1;
    }
}
