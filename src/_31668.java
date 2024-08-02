import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _31668 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        System.out.println(M/N*K);
    }

}
