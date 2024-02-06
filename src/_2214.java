import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _2214 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            if (row + col == 0) {
                break;
            }

            List<String> horizontals = new ArrayList<>();
            List<String> verticals = new ArrayList<>();

            int lines = row * 2 + 1;
            for (int i = 0; i < lines; i++) {
                ((i%2 == 0) ? horizontals : verticals).add(br.readLine());
            }
            sb.append(String.format("%d squares\n", countSquares(row, col, horizontals, verticals)));
        }

        System.out.print(sb);
    }

    private static int countSquares(int row, int col, List<String> horizontals, List<String> verticals) {
        int result = 0;
        for (int r1=0; r1<row; r1++) {
            for (int c1=0; c1<col; c1++) {
                int r2 = r1 + 1;
                int c2 = c1 + 1;
                while (r2 <= row && c2 <= col) {
//                    System.out.printf("%d %d %d %d\n",r1,c1,r2,c2);
                    boolean isUpAllSame = isAllSame(horizontals, r1, c1, r1, c2 - 1, '-');
                    boolean isDownAllSame = isAllSame(horizontals, r2, c1, r2, c2 - 1, '-');
                    boolean isLeftAllSame = isAllSame(verticals, r1, c1, r2 - 1, c1, '|');
                    boolean isRightAllSame = isAllSame(verticals, r1, c2, r2 - 1, c2, '|');
//                    System.out.printf("%b %b %b %b\n",isUpAllSame, isDownAllSame, isLeftAllSame, isRightAllSame);
                    if (isUpAllSame && isDownAllSame && isLeftAllSame && isRightAllSame) {
                        result++;
                    }
                    r2++;
                    c2++;
                }
            }
        }
        return result;
    }

    private static boolean isAllSame(List<String> string, int r1, int c1, int r2, int c2, char value) {
        for (int r=r1; r<=r2; r++) {
            for (int c=c1; c<=c2; c++) {
                if (string.get(r).charAt(c) != value) {
                    return false;
                }
            }
        }
        return true;
    }

}
