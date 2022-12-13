import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _24266 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        System.out.printf("%d\n3",N*N*N);
    }
}
