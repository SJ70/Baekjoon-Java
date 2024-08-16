import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _31822 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String target = br.readLine().substring(0, 5);
        int result = 0;
        int n = Integer.parseInt(br.readLine());
        for (int i=0; i<n; i++) {
            String str = br.readLine();
            if (str.startsWith(target)) {
                result++;
            }
        }
        System.out.println(result);
    }

}
