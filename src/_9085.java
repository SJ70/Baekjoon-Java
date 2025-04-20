import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _9085 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t=0; t<T; t++) {
            br.readLine();
            System.out.println(Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sum());
        }
    }

}
