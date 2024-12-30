import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _17614 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = 0;
        for (int i=1; i<=N; i++) {
            String str = String.valueOf(i);
            for (char c : str.toCharArray()) {
                if (c == '3' || c == '6' || c == '9') {
                    result++;
                }
            }
        }
        System.out.println(result);
    }

}
