import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _20233 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int x = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());
        int t = Integer.parseInt(br.readLine());
        int result1 = a + (21 * (Math.max(t, 30) - 30) * x);
        int result2 = b + (21 * (Math.max(t, 45) - 45) * y);
        System.out.printf("%d %d\n", result1, result2);
    }

}
