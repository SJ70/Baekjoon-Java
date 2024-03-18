import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _31614 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int h = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        System.out.println(h*60 + m);
    }

}
