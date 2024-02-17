import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2435 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int[] prefix = new int[n + 1];
        for (int i=1; i<=n; i++) {
            prefix[i] = prefix[i-1] + arr[i-1];
        }

        int maxTemp = Integer.MIN_VALUE;
        for (int i=0; i+k<=n; i++) {
            int temp = prefix[i+k] - prefix[i];
            maxTemp = Math.max(maxTemp, temp);
        }

        System.out.println(maxTemp);

    }

}
