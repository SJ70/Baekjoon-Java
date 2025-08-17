import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _85739 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());
        int z = Integer.parseInt(br.readLine());
        System.out.println((x + y) * 2 <= z * 2 + 1 ? 1 : 0);
    }

}
