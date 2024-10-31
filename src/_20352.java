import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _20352 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double area = Double.parseDouble(br.readLine());
        double r = Math.sqrt(area / Math.PI);
        System.out.println(r * 2 * Math.PI);
    }

}
