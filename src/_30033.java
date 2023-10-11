import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _30033 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] plan = br.readLine().split(" ");
        String[] done = br.readLine().split(" ");
        int result = 0;
        for (int i=0; i<n; i++) {
            if (Integer.parseInt(plan[i]) <= Integer.parseInt(done[i])) {
                result++;
            }
        }
        System.out.println(result);
    }
}
