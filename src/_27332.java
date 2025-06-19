import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _27332 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int result = a + b * 7;
        System.out.println(result > 30 ? 0 : 1);
    }

}
