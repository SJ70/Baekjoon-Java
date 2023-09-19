import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _30030 {
    public static void main(String[] args) throws IOException {
        int price = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        System.out.println(price / 11 * 10);
    }
}
