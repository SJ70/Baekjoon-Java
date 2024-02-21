import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1931 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[][] arr = new long[n][2];
        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Long.parseLong(st.nextToken()); // start
            arr[i][1] = Long.parseLong(st.nextToken()); // end
        }

        Arrays.sort(arr, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return Long.compare(o1[0], o2[0]);
            }
            return Long.compare(o1[1], o2[1]);
        });

        long currentTime = 0;
        int result = 0;
        for (int i=0; i<n; i++) {
            long start = arr[i][0];
            long end = arr[i][1];

            if (start >= currentTime) {
                currentTime = end;
                result++;
            }
        }

        System.out.println(result);

    }

}
