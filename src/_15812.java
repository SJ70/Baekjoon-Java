import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _15812 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[][] arr = new int[R][C];
        for (int r=0; r<R; r++) {
            String input = br.readLine();
            for (int c=0; c<C; c++) {
                arr[r][c] = input.charAt(c) - '0';
            }
        }

        int minTime = Integer.MAX_VALUE;
        for (int i=0; i<R*C; i++) {
            int r1 = i / C;
            int c1 = i % C;
            if (arr[r1][c1] == 1) {
                continue;
            }
            for (int j=0; j<R*C; j++) {
                int r2 = j / C;
                int c2 = j % C;
                if (arr[r2][c2] == 1 || (r1 == r2 && c1 == c2)) {
                    continue;
                }
                int time = 0;
                for (int k=0; k<R*C; k++) {
                    int r = k / C;
                    int c = k % C;
                    if (arr[r][c] == 1) {
                        int d1 = Math.abs(r1 - r) + Math.abs(c1 - c);
                        int d2 = Math.abs(r2 - r) + Math.abs(c2 - c);
                        int dist = Math.min(d1, d2);
                        time = Math.max(time, dist);
                    }
                }
                minTime = Math.min(minTime, time);
            }
        }

        System.out.println(minTime);
    }

}
