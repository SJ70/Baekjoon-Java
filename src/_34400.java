import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _34400 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t=0; t<T; t++) {
            int time = Integer.parseInt(br.readLine());
            if (time % 25 < 17) {
                System.out.println("ONLINE");
            } else {
                System.out.println("OFFLINE");
            }
        }
    }

}
