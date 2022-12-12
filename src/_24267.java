import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _24267 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        long cnt = 0l;
        long tmp = 0l;
        for(int i=1; i<=N-2; i++){
            tmp+=i;
            cnt+=tmp;
        }
        System.out.printf("%d\n3",cnt);
    }
}
