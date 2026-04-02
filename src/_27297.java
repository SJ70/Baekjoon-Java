import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class _27297 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[][] arr = new long[N][M];
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                arr[j][i] = Long.parseLong(st.nextToken());
            }
        }
        long resultDist = 0;
        long[] resultArr = new long[N];
        for (int i=0; i<N; i++) {
            Arrays.sort(arr[i]);

            long mid = M % 2 == 1
                    ? arr[i][M/2]
                    : (arr[i][M/2] + arr[i][M/2-1]) / 2;
            for (long value : arr[i]) {
                resultDist += Math.abs(mid - value);
            }
            resultArr[i] = mid;
        }

        System.out.println(resultDist);
        System.out.println(Arrays.stream(resultArr).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
    }

}
