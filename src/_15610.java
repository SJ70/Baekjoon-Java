import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _15610 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double n = Double.parseDouble(br.readLine());
        System.out.println(Math.sqrt(n) * 4);
    }

}
