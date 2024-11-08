import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1568 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total = Integer.parseInt(br.readLine());
        int result = 0;
        int i = 1;
        while (total > 0) {
            if (total < i) {
                i = 1;
            }
            total -= i;
            result++;
            i++;
        }
        System.out.println(result);
    }

}
