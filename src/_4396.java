import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _4396 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        boolean[][] isMine = new boolean[N][N];
        for (int r=0; r<N; r++) {
            String str = br.readLine();
            for (int c=0; c<N; c++) {
                isMine[r][c] = (str.charAt(c) == '*');
            }
        }

        boolean[][] isOpened = new boolean[N][N];
        for (int r=0; r<N; r++) {
            String str = br.readLine();
            for (int c=0; c<N; c++) {
                isOpened[r][c] = (str.charAt(c) == 'x');
            }
        }

        char[][] result = new char[N][N];
        for (int r=0; r<N; r++) {
            for (int c=0; c<N; c++) {
                if (!isOpened[r][c]) {
                    result[r][c] = '.';
                    continue;
                }
                result[r][c] = '0';
                for (int r1=r-1; r1<=r+1; r1++) {
                    if (r1<0 || r1>=N) {
                        continue;
                    }
                    for (int c1=c-1; c1<=c+1; c1++) {
                        if (c1<0 || c1>=N) {
                            continue;
                        }
                        if (r==r1 && c==c1) {
                            continue;
                        }
                        if (isMine[r1][c1]) {
                            result[r][c]++;
                        }
                    }
                }
            }
        }

        for (int r=0; r<N; r++) {
            for (int c=0; c<N; c++) {
                if (isOpened[r][c] && isMine[r][c]) {
                    for (int r1=0; r1<N; r1++) {
                        for (int c1=0; c1<N; c1++) {
                            if (isMine[r1][c1]) {
                                result[r1][c1] = '*';
                            }
                        }
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int r=0; r<N; r++) {
            for (int c = 0; c < N; c++) {
                sb.append(result[r][c]);
            }
            sb.append('\n');
        }
        System.out.print(sb);

    }

}
