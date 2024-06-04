import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _5555 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String target = br.readLine();
        int n = Integer.parseInt(br.readLine());
        int result = 0;
        for (int i=0; i<n; i++) {
            if (br.readLine().repeat(2).contains(target)) {
                result++;
            }
        }
        System.out.println(result);
    }

}
