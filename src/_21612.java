import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _21612 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int b = Integer.parseInt(br.readLine());
        int p = 5 * b - 400;
        System.out.println(p);
        System.out.println(Integer.compare(100, p));
    }

}
