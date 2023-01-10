import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1075 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int F = Integer.parseInt(br.readLine());

        N = N - N%100;
        int result = F * (N/F);
        if(result<N) result+=F;

        result%=100;
        if(result<10) System.out.println("0"+result);
        else System.out.println(result);
    }
}
