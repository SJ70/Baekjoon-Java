import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _20733 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int length = input.length() / 3;
        String a = input.substring(0, length);
        String b = input.substring(length, 2 * length);
        String c = input.substring(2 * length, 3 * length);
        if (a.equals(b)) {
            System.out.println(a);
        }
        else if (b.equals(c)) {
            System.out.println(b);
        }
        else {
            System.out.println(c);
        }
    }

}
