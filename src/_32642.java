import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _32642 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        long result = 0;
        long rage = 0;
        for (String str : br.readLine().split(" ")) {
            rage += str.equals("1") ? 1 : -1;
            result += rage;
        }
        System.out.println(result);
    }

}
