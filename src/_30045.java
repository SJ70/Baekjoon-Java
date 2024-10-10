import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _30045 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = 0;
        for (int i=0; i<N; i++) {
            String str = br.readLine();
            if (str.contains("01") || str.contains("OI")) {
                result++;
            }
        }
        System.out.println(result);
    }

}
