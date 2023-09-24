import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _15232 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int r = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        String str = "*".repeat(c) + '\n';
        str = str.repeat(r);

        System.out.print(str);
    }
}
