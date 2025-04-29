import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _32722 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n;
        n = Integer.parseInt(br.readLine());
        if (n != 1 && n != 3) {
            System.out.println("EI");
            return;
        }
        n = Integer.parseInt(br.readLine());
        if (n != 6 && n != 8) {
            System.out.println("EI");
            return;
        }
        n = Integer.parseInt(br.readLine());
        if (n != 2 && n != 5) {
            System.out.println("EI");
            return;
        }
        System.out.println("JAH");
    }

}
