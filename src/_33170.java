import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _33170 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = Integer.parseInt(br.readLine()) + Integer.parseInt(br.readLine()) + Integer.parseInt(br.readLine());
        System.out.println(sum <= 21 ? 1 : 0);
    }

}
