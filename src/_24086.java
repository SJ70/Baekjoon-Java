import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _24086 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Past = Integer.parseInt(br.readLine());
        int Current = Integer.parseInt(br.readLine());
        System.out.println(Current-Past);
    }
}
