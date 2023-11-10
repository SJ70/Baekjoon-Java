import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _11170 {

    public static void main(String[] args) throws IOException {

        int[] arr = new int[1000002];
        for (int i=0; i<=1000000; i++) {
            int zeroCount = (int) Arrays.stream(String.valueOf(i).split(""))
                    .filter(value -> value.equals("0"))
                    .count();
            arr[i+1] = arr[i] + zeroCount;
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            int result = arr[to+1] - arr[from];
            System.out.println(result);
        }
    }

}
