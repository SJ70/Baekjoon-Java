import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _31518 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i=0; i<3; i++) {
            boolean contains7 = Arrays.asList(br.readLine().split(" ")).contains("7");
            if (!contains7) {
                System.out.println(0);
                return;
            }
        }
        System.out.println(777);

    }

}
