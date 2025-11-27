import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2296 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][3];
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            arr[i][0] = x;
            arr[i][1] = y;
            arr[i][2] = value;
        }
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        int[] dp1 = new int[N];
        for (int i=0; i<N; i++) {
            for (int j=0; j<i; j++) {
                if (arr[i][1] > arr[j][1] && dp1[i] < dp1[j]) {
                    dp1[i] = dp1[j];
                }
            }
            dp1[i] += arr[i][2];
        }

        int[] dp2 = new int[N];
        for (int i=0; i<N; i++) {
            for (int j=0; j<i; j++) {
                if (arr[i][1] < arr[j][1] && dp2[i] < dp2[j]) {
                    dp2[i] = dp2[j];
                }
            }
            dp2[i] += arr[i][2];
        }

        int max = 0;
        for (int i=0; i<N; i++) {
            max = Math.max(max, dp1[i]);
            max = Math.max(max, dp2[i]);
        }
        System.out.println(max);

    }

}
