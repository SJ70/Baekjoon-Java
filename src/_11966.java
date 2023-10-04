import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _11966 {
    public static void main(String[] args) throws IOException {
        int number = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        while (number >= 2) {
            if (number % 2 != 0) {
                System.out.println(0);
                return;
            }
            number /= 2;
        }
        System.out.println(1);
    }
}
