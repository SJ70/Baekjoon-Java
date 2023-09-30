import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _29295 {

    private static char[] DIR_CHAR = new char[] {'N', 'E', 'S', 'W'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int dir = 0;

        for (int i=0; i<10; i++) {
            dir += Integer.parseInt(br.readLine());
        }

        System.out.println(DIR_CHAR[dir%4]);
    }
}
