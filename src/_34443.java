import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _34443 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        int p = Integer.parseInt(br.readLine());
        System.out.println(n * p);
    }

}
