import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _32297 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        String str = br.readLine();
        System.out.println(str.contains("gori") ? "YES" : "NO");
    }

}
