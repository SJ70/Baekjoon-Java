import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _28248 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int result = a * 50 - b * 10 + (a > b ? 500 : 0);
        System.out.println(result);
    }

}
