import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _18141 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (i==j) {
                    continue;
                }
                for (int k=0; k<n; k++) {
                    if (i==k || j==k) {
                        continue;
                    }
                    if ((arr[i] - arr[j]) % arr[k] != 0) {
                        System.out.println("no");
                        return;
                    }
                }
            }
        }
        System.out.println("yes");

    }

}
