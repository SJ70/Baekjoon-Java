import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _27494 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = 0;
        for (int i=2023; i<=N; i++) {
            char[] target = {'2', '0', '2', '3'};
            int idx = 0;
            for (char c : String.valueOf(i).toCharArray()) {
                if (idx < 4 && target[idx] == c) {
                    idx++;
                }
            }
            if (idx == 4) {
                result++;
            }
        }
        System.out.println(result);
    }

}
