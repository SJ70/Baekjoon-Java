import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _6887 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = (int)Math.floor(Math.sqrt(N));
        System.out.printf("The largest square has side length %d.",result);
    }
}
