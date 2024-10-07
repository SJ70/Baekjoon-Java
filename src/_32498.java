import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _32498 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = 0;
        for (int i=0; i<N; i++) {
            int value = Integer.parseInt(br.readLine());
            if (value % 2 == 1) {
                result++;
            }
        }
        System.out.println(result);
    }

}
