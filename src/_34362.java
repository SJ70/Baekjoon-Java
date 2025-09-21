import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _34362 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Double value = Double.parseDouble(br.readLine());
        System.out.println(value - 0.3);
    }

}
