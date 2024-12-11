import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _32778 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split("\\(");
        System.out.println(split[0]);
        if (split.length == 1) {
            System.out.println('-');
        }
        else {
            System.out.println(split[1].split("\\)")[0]);
        }
    }

}
