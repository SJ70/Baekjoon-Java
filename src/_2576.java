import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2576 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        int min = 999;
        for(int i=0; i<7; i++){
            int n = Integer.parseInt(br.readLine());
            if(n%2==0) continue;
            if(n<min) min=n;
            sum+=n;
        }
        if(sum==0) System.out.println(-1);
        else System.out.printf("%d\n%d",sum,min);
    }
}
