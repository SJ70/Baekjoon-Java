import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _16931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n+2][m+2];

        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = n * m * 2;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                int value = arr[i][j];
                result += Math.max(value - arr[i-1][j], 0);
                result += Math.max(value - arr[i+1][j], 0);
                result += Math.max(value - arr[i][j-1], 0);
                result += Math.max(value - arr[i][j+1], 0);
            }
        }

        System.out.println(result);
    }
}
