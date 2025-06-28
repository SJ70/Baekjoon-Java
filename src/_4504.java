import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _4504 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        while (true) {
            int value = Integer.parseInt(br.readLine());
            if (value == 0) {
                return;
            }
            if (value % N == 0) {
                System.out.printf("%d is a multiple of %d.\n", value, N);
            }
            else {
                System.out.printf("%d is NOT a multiple of %d.\n", value, N);
            }
        }
    }

}
