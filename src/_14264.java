import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _14264 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double n = Double.parseDouble(br.readLine());
        double height = n / 2 * Math.sqrt(3);
        System.out.println(n / 2 * height);
    }
}
