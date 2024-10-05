import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _32458 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double value = Double.parseDouble(br.readLine());
        System.out.println((int)Math.floor(value));
    }

}
