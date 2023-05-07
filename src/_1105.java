import java.io.*;
import java.util.StringTokenizer;

public class _1105 {
    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int cnt = 0;
        if(L==R){
            while(L>0){
                if(L%10==8) cnt++;
                L/=10;
            }
        }
        else{
            for(int i=1000000000; i>0; i/=10){
                if(L/i==R/i){
                    if(L/i==8) cnt++;
                }
                else break;
                L%=i;
                R%=i;
            }
        }
        System.out.println(cnt);
    }
}
