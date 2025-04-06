import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _33162 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = N / 2 + (N % 2) * 3;
        System.out.println(result);
    }

}
