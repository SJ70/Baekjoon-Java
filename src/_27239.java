import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _27239 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.print((char)('a' + (n-1) % 8));
        System.out.print((n-1) / 8 + 1);
    }

}
