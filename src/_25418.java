import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _25418 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int[] arr = new int[end + 1];
        Arrays.fill(arr, Integer.MAX_VALUE / 2);
        arr[start] = 0;

        for (int i=start+1; i<=end; i++) {
            arr[i] = Math.min(arr[i - 1] + 1, arr[i]);
            if (i%2==0) {
                arr[i] = Math.min(arr[i / 2] + 1, arr[i]);
            }
        }
        System.out.println(arr[end]);
    }

}
