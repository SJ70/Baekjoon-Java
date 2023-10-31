import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _23808 {

    private static int n;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        sb.append(sides().repeat(2 * n));
        sb.append(solid().repeat(n));
        sb.append(sides().repeat(n));
        sb.append(solid().repeat(n));
        System.out.print(sb);
    }

    private static String sides() {
        return "@".repeat(n) + " ".repeat(3 * n) + "@".repeat(n) + '\n';
    }

    private static String solid() {
        return "@".repeat(5 * n) + '\n';
    }

}
