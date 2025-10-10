import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _34380 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        int N = Integer.parseInt(br.readLine());
        System.out.println((20 + N) * 2);
    }

}
