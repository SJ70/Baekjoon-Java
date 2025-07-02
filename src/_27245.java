import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _27245 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());
        int z = Integer.parseInt(br.readLine());
        boolean a = Math.min(x, y) >= z * 2;
        boolean b = Math.max(x, y) <= Math.min(x, y) * 2;
        System.out.println(a && b ? "good" : "bad");
    }

}
