import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

public class _16924 {

    private static int R, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        String[] arr = new String[R];
        for (int r=0; r<R; r++) {
            arr[r] = br.readLine();
        }
        boolean[][] filled = new boolean[R][C];

        int resultCnt = 0;
        StringBuilder sb = new StringBuilder();
        for (int r=0; r<R; r++) {
            for (int c=0; c<C; c++) {
                if (arr[r].charAt(c) == '.') {
                    continue;
                }
                int i = 1;
                for (; true; i++) {
                    if (r-i < 0 || r+i >= R || c-i < 0 || c+i >= C ||
                            arr[r-i].charAt(c) == '.' ||
                            arr[r+i].charAt(c) == '.' ||
                            arr[r].charAt(c-i) == '.' ||
                            arr[r].charAt(c+i) == '.' ) {
                        break;
                    }
                    else {
                        filled[r-i][c] = filled[r+i][c] = filled[r][c-i] = filled[r][c+i] = true;
                    }
                }
                if (i > 1) {
                    filled[r][c] = true;
                    resultCnt++;
                    sb.append(String.format("%d %d %d\n", r+1, c+1, i-1));
                }

            }
        }

        for (int r=0; r<R; r++) {
            for (int c=0; c<C; c++) {
                if (arr[r].charAt(c) == '*' && !filled[r][c]) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(resultCnt);
        System.out.print(sb);
    }

}
