import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _22983 {

    private static int R, C;
    private static String[] board;
    private static int[][] arrV;
    private static int[][] arrH;
    private static int[][] maxSize;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new String[R];
        for (int r=0; r<R; r++) {
            board[r] = br.readLine();
        }

        // 가로 연속성
        arrH = new int[R][C];
        for (int r=0; r<R; r++) {
            arrH[r][0] = 1;
            for (int c=1; c<C; c++) {
                arrH[r][c] = 1;
                if (board[r].charAt(c) != board[r].charAt(c-1)) {
                    arrH[r][c] += arrH[r][c-1];
                }
            }
        }

        // 세로 연속성
        arrV = new int[R][C];
        for (int c=0; c<C; c++) {
            arrV[0][c] = 1;
            for (int r=1; r<R; r++) {
                arrV[r][c] = 1;
                if (board[r].charAt(c) != board[r-1].charAt(c)) {
                    arrV[r][c] += arrV[r-1][c];
                }
            }
        }

        // 측정
        long result = 0;
        maxSize = new int[R][C];
        for (int r=0; r<R; r++) {
            for (int c=0; c<C; c++) {
                maxSize[r][c] = Math.min(arrH[r][c], arrV[r][c]);
                if (r>0 && c>0) {
                    if (board[r].charAt(c) != board[r-1].charAt(c-1)) {
                        // 좌측상단 칸이 다른 값이면 이전 최대 크기를 생각하지 않음
                        maxSize[r][c] = 1;
                    }
                    else {
                        maxSize[r][c] = Math.min(maxSize[r][c], maxSize[r-1][c-1] + 1);
                    }
                }
                result += maxSize[r][c];
            }
        }
        System.out.println(result);

    }

}
