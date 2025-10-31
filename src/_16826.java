import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _16826 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;
        int status = 0;
        for (char c : br.readLine().toCharArray()) {
            if (c == 'R') {
                status++;
            }
            else {
                status--;
            }
            if (status == 4) {
                status = 0;
                result++;
            }
            if (status == -4) {
                status = 0;
            }
        }
        System.out.println(result);
    }

}
