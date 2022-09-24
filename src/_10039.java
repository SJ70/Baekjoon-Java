import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _10039 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        for(int i=0; i<5; i++){
            int N = Integer.parseInt(br.readLine());
            if(N<40) N=40;
            sum += N;
        }
        System.out.println(sum/5);
    }
}