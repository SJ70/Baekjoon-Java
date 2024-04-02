import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _27310 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int length = str.length();
        int col = 0;
        int underBar = 0;
        for (char c : str.toCharArray()) {
            if (c == ':') {
                col++;
            }
            else if (c == '_') {
                underBar++;
            }
        }

        System.out.println(length + col + underBar * 5);

    }

}
