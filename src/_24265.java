import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _24265 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        long result = N*((N-1)/2) + ((N%2==0)?N/2:0);
        System.out.printf("%d\n2",result);
    }
}
