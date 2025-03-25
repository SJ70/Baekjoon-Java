import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _16483 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double T = Double.parseDouble(br.readLine());
        double result = (T / 2) * (T / 2);
        System.out.printf("%d\n", Math.round(result));
    }

}
