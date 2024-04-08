import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9913 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int maxCnt = 0;

        int[] arr = new int[10001];

        int n = Integer.parseInt(br.readLine());
        for (int i=0; i<n; i++) {
            int value = Integer.parseInt(br.readLine());
            arr[value]++;

            if (arr[value] > maxCnt) {
                maxCnt = arr[value];
            }
        }

        System.out.println(maxCnt);
    }

}
