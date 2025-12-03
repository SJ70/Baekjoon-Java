import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _15559 {

    private static int R, C;
    private static int[][] dr, dc;
    private static int[][] groupNums;
    private static int groupNum = 0;
    private static int groupCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        dr = new int[R][C];
        dc = new int[R][C];

        for (int r=0; r<R; r++) {
            String str = br.readLine();
            for (int c=0; c<C; c++) {
                switch (str.charAt(c)) {
                    case 'E' :
                        dc[r][c] = 1;
                        break;
                    case 'W' :
                        dc[r][c] = -1;
                        break;
                    case 'N' :
                        dr[r][c] = -1;
                        break;
                    case 'S' :
                        dr[r][c] = 1;
                        break;
                }
            }
        }

        groupNums = new int[R][C];
        for (int r=0; r<R; r++) {
            for (int c=0; c<C; c++) {
                if (groupNums[r][c] == 0) {
                    groupNum++;
                    groupCnt++;
                    visit(r, c);
                }
            }
        }

        System.out.println(groupCnt);
    }

    private static void visit(int r, int c) {
        groupNums[r][c] = groupNum;

        int nextR = r + dr[r][c];
        int nextC = c + dc[r][c];
        if (groupNums[nextR][nextC] == 0) {
            visit(nextR, nextC);
        }
        if (groupNums[nextR][nextC] == groupNum) {
            return;
        }
        if (groupNums[nextR][nextC] != groupNum) {
            groupCnt--;
            return;
        }
    }

}
