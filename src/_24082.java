import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _24082 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.print(N*N*N);
    }
}
