import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _23795 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;
        int tmp;
        while((tmp=Integer.parseInt(br.readLine()))>-1){
            result+=tmp;
        }
        System.out.println(result);
    }
}
