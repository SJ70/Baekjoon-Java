import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _31403 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String aStr = br.readLine();
        String bStr = br.readLine();
        String cStr = br.readLine();

        System.out.println(Integer.parseInt(aStr) + Integer.parseInt(bStr) - Integer.parseInt(cStr));
        System.out.println(Integer.parseInt(aStr + bStr) - Integer.parseInt(cStr));

    }

}
