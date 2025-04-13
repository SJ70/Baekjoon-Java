import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _13164 {

    private static int N;
    private static int K;

    private static int[] heights;
    private static int[] mergeCosts;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        heights = new int[N];
        for (int i=0; i<N; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }

        mergeCosts = new int[N-1];
        for (int i=0; i<N-1; i++) {
            mergeCosts[i] = heights[i+1] - heights[i];
        }

        Arrays.sort(mergeCosts);

        int result = 0;
        for (int i=0; i<N-K; i++) {
            result += mergeCosts[i];
        }
        System.out.println(result);

    }

}
