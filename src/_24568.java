import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _24568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int LargeBox = Integer.parseInt(br.readLine());
        int SmallBox = Integer.parseInt(br.readLine());
        int cnt = LargeBox*8 + SmallBox*3;
        System.out.println(cnt-28);
    }
}
