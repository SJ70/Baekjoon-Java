import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _4806 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        int i = 0;
        while ((input = br.readLine()) != (null)) {
            i++;
        }
        System.out.println(i);
    }

}
