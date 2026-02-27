import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _16505 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = (int) Math.pow(2, N);
        int[][] arr = new int[M][M];
        for (int m=M; m>=1; m/=2) {
            for (int r0=0; r0<M; r0+=m) {
                for (int c0=0; c0<M; c0+=m) {
                    if (arr[r0+m-1][c0+m-1] != 0) {
                        continue;
                    }
                    for (int r=r0+m-1; r>=r0; r--) {
                        for (int c=c0+m-1; c>=c0; c--) {
                            if (r%m + c%m >= m) {
                                arr[r][c] = 1;
                            } else {
                                break;
                            }
                        }
                    }
                }
            }
        }
        for (int r=M-1; r>=0; r--) {
            for (int c=M-1; c>=0; c--) {
                if (arr[r][c] == 0) {
                    break;
                }
                arr[r][c] = 2;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int r=0; r<M; r++) {
            for (int c=0; c<M; c++) {
                if (arr[r][c] == 2) {
                    break;
                }
                sb.append(arr[r][c] == 0 ? '*' : ' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

}
