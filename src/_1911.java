import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1911 {

    private static int N, L;
    private static int[][] water;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        water = new int[N][2];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            water[i][0] = Integer.parseInt(st.nextToken());
            water[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(water, (a, b) -> a[0] - b[0]);

        int result = 0;
        int idx = 0;
        int arrIdx = 0;
        while (idx <= 1000000000) {
            if (arrIdx >= N) {
                break;
            }
            if (idx < water[arrIdx][0]) {
                idx = water[arrIdx][0];
            }
            if (water[arrIdx][0] <= idx && idx < water[arrIdx][1]) {
                int length = water[arrIdx][1] - idx;
                int cnt = (length + L - 1) / L;
//                System.out.printf("%d ~ %d, %d\n", idx, idx + L * cnt - 1, cnt);
                result += cnt;
                idx += L * cnt;
            }
            if (water[arrIdx][1] <= idx) {
                arrIdx++;
            }
        }
        System.out.println(result);

    }

}
