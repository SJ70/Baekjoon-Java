import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _16396 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] arr = new boolean[10000];
        int n = Integer.parseInt(br.readLine());
        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int until = Integer.parseInt(st.nextToken()) - 1;
            for (int j=from; j<until; j++) {
                arr[j] = true;
            }
        }
        int result = 0;
        for (int i=0; i<10000; i++) {
            if (arr[i]) {
                result++;
            }
        }
        System.out.println(result);

    }

}
