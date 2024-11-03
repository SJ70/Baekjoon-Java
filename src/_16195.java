import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _16195 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[][] arr = new int[1000][1001];
        for (int d=1; d<=3; d++) {
            if (d <= 1000) {
                arr[0][d] = 1;
            }
        }
        for (int i=0; i<=1000; i++) {
            for (int j=0; j<1000-1; j++) {
                if (arr[j][i] == 0) {
                    continue;
                }
                for (int d=1; d<=3; d++) {
                    if (i+d <= 1000) {
                        arr[j+1][i+d] += arr[j][i];
                        arr[j+1][i+d] %= 1000000009;
                    }
                }
            }
        }

        for (int t=0; t<T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int result = 0;
            for (int i=0; i<M; i++) {
                result += arr[i][N];
                result %= 1000000009;
            }
            sb.append(result);
            sb.append('\n');
        }
        System.out.print(sb);
    }

}
