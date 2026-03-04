import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _34530 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int deg = Integer.parseInt(br.readLine());
        for (int i=1; true; i++) {
            if (deg * i % 360 == 0) {
                System.out.println(i);
                return;
            }
        }
    }

}
