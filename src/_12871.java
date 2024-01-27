import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _12871 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();

        String repeatedA = a.repeat(b.length());
        String repeatedB = b.repeat(a.length());

        System.out.println(repeatedA.equals(repeatedB) ? 1 : 0);
    }

}
