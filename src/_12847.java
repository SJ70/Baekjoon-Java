import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _12847 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Long> arr = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            long value = Long.parseLong(st.nextToken());
            arr.add(value);
        }

        long result = 0;
        for (int i=0; i<m; i++) {
            result += arr.get(i);
        }

        long resultTmp = result;
        for (int i=m; i<n; i++) {
            resultTmp -= arr.get(i-m);
            resultTmp += arr.get(i);
            result = Math.max(result, resultTmp);
        }

        System.out.println(result);
    }
}
