import java.io.*;
import java.util.*;

public class _27736 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = 0;
        int zero = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int value = Integer.parseInt(st.nextToken());
            if(value==0) zero++;
            else result += value;
        }
        if(zero*2>=N) System.out.println("INVALID");
        else System.out.println(result>0?"APPROVED":"REJECTED");
    }
}
