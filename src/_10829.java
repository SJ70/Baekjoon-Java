import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _10829 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long value = Long.parseLong(br.readLine());
        System.out.println(Long.toBinaryString(value));
    }

}
