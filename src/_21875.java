import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _21875 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String from = br.readLine();
        String to = br.readLine();
        int dx = Math.abs(from.charAt(0) - to.charAt(0));
        int dy = Math.abs(from.charAt(1) - to.charAt(1));
        System.out.printf("%d %d\n", Math.min(dx, dy), Math.max(dx, dy));
    }

}
