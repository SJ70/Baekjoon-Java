import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _15051 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        int resultA = c * 4 + b * 2;
        int resultB = a * 2 + c * 2;
        int resultC = a * 4 + b * 2;
        System.out.println(Math.min(Math.min(resultA, resultB), resultC));
    }

}
