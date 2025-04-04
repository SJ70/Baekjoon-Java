import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _11816 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        if (str.charAt(0) == '0') {
            if (str.charAt(1) == 'x') {
                System.out.println(Integer.parseInt(str.substring(2), 16));
                return;
            }
            System.out.println(Integer.parseInt(str.substring(1), 8));
            return;
        }
        System.out.println(str);
    }

}
