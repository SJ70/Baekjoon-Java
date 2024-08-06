import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _16600 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Double num = Double.parseDouble(br.readLine());
        System.out.println(Math.sqrt(num) * 4);

    }

}
