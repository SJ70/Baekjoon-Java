import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11955 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        char[][] values = new char[R][C];
        for (int r=0; r<R; r++) {
            values[r] = br.readLine().toCharArray();
        }

        int[][] prefixSum = new int[R][C];
        for (int r=0; r<R; r++) {
            for (int c=0; c<C; c++) {
                if (values[r][c] == '*') {
                    prefixSum[r][c] = 1;
                }
            }
        }
        for (int r=1; r<R; r++) {
            for (int c=0; c<C; c++) {
                prefixSum[r][c] += prefixSum[r-1][c];
            }
        }
        for (int r=0; r<R; r++) {
            for (int c=1; c<C; c++) {
                prefixSum[r][c] += prefixSum[r][c-1];
            }
        }

        int maxCount = 0;
        int maxCountPositionR = 0;
        int maxCountPositionC = 0;
        for (int r=0; r<=R-K; r++) {
            for (int c=0; c<=C-K; c++) {
                int count = prefixSum[r+K-2][c+K-2] - prefixSum[r+K-2][c] - prefixSum[r][c+K-2] + prefixSum[r][c];
                if (count > maxCount) {
                    maxCount = count;
                    maxCountPositionR = r;
                    maxCountPositionC = c;
                }
            }
        }

        for (int r=maxCountPositionR+1; r<maxCountPositionR+K-1; r++) {
            values[r][maxCountPositionC] = values[r][maxCountPositionC+K-1] = '|';
        }
        for (int c=maxCountPositionC+1; c<maxCountPositionC+K-1; c++) {
            values[maxCountPositionR][c] = values[maxCountPositionR+K-1][c] = '-';
        }
        values[maxCountPositionR][maxCountPositionC] = '+';
        values[maxCountPositionR][maxCountPositionC+K-1] = '+';
        values[maxCountPositionR+K-1][maxCountPositionC] = '+';
        values[maxCountPositionR+K-1][maxCountPositionC+K-1] = '+';

        StringBuilder sb = new StringBuilder();
        sb.append(maxCount);
        for (int r=0; r<R; r++) {
            sb.append('\n');
            for (int c=0; c<C; c++) {
                sb.append(values[r][c]);
            }
        }
        System.out.println(sb);

    }

}
