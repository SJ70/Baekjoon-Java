import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _16935 {

    private static int R, C;
    private static int[][] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int rotates = Integer.parseInt(st.nextToken());

        arr = new int[R][C];
        for (int r=0; r<R; r++) {
            arr[r] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<rotates; i++) {
            int tmp;
            int[][] tmpArr;
            switch (Integer.parseInt(st.nextToken())) {
                case 1 :
                    tmp = R/2;
                    for (int r=0; r<tmp; r++) {
                        for (int c=0; c<C; c++) {
                            int tmpValue = arr[r][c];
                            arr[r][c] = arr[R-1-r][c];
                            arr[R-1-r][c] = tmpValue;
                        }
                    }
                    break;
                case 2 :
                    tmp = C/2;
                    for (int r=0; r<R; r++) {
                        for (int c=0; c<tmp; c++) {
                            int tmpValue = arr[r][c];
                            arr[r][c] = arr[r][C-1-c];
                            arr[r][C-1-c] = tmpValue;
                        }
                    }
                    break;
                case 3 :
                    tmpArr = new int[C][R];
                    for (int r=0; r<R; r++) {
                        for (int c=0; c<C; c++) {
                            tmpArr[c][R-1-r] = arr[r][c];
                        }
                    }
                    arr = tmpArr;
                    tmp = R;
                    R = C;
                    C = tmp;
                    break;
                case 4 :
                    tmpArr = new int[C][R];
                    for (int r=0; r<R; r++) {
                        for (int c=0; c<C; c++) {
                            tmpArr[C-1-c][r] = arr[r][c];
                        }
                    }
                    arr = tmpArr;
                    tmp = R;
                    R = C;
                    C = tmp;
                    break;
                case 5 :
                    tmpArr = new int[R/2][C/2];
                    for (int r=0; r<R/2; r++) {
                        for (int c=0; c<C/2; c++) {
                            tmpArr[r][c] = arr[r][c];
                            arr[r][c] = arr[r+R/2][c];
                            arr[r+R/2][c] = arr[r+R/2][c+C/2];
                            arr[r+R/2][c+C/2] = arr[r][c+C/2];
                            arr[r][c+C/2] = tmpArr[r][c];
                        }
                    }
                    break;
                case 6 :
                    tmpArr = new int[R/2][C/2];
                    for (int r=0; r<R/2; r++) {
                        for (int c=0; c<C/2; c++) {
                            tmpArr[r][c] = arr[r][c];
                            arr[r][c] = arr[r][c+C/2];
                            arr[r][c+C/2] = arr[r+R/2][c+C/2];
                            arr[r+R/2][c+C/2] = arr[r+R/2][c];
                            arr[r+R/2][c] = tmpArr[r][c];
                        }
                    }
                    break;
                }
        }

        StringBuilder sb = new StringBuilder();
        for (int r=0; r<R; r++) {
            for (int c=0; c<C; c++) {
                sb.append(arr[r][c]);
                sb.append((c == C-1) ? '\n' : ' ');
            }
        }
        System.out.print(sb);

    }

}
