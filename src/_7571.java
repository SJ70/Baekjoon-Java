import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _7571 {

    private static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] rValues = new int[M];
        int[] cValues = new int[M];
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            rValues[i] = Integer.parseInt(st.nextToken());
            cValues[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(rValues);
        Arrays.sort(cValues);

        int rAvg = rValues[M/2];
        int cAvg = cValues[M/2];

        int result = 0;
        for (int i=0; i<M; i++) {
            result += Math.abs(rValues[i] - rAvg);
            result += Math.abs(cValues[i] - cAvg);
        }

        System.out.println(result);
    }

}
