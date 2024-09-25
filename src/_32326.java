import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _32326 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int R = Integer.parseInt(br.readLine());
        int G = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        System.out.println(3*R + 4*G + 5*B);

    }

}
