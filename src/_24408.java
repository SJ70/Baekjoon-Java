import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _24408 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int tmp = -1;
        for (int i=0; i<N; i++) {
            int value = Integer.parseInt(br.readLine());
            if (tmp == -1) {
                tmp = value;
                continue;
            }
            if (value >= tmp && value % tmp == 0) {
                System.out.println(value);
                tmp = -1;
            }
        }
    }

}
