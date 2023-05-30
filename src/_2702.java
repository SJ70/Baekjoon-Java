import java.io.*;
import java.util.*;

public class _2702 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            for(int j=1; j<=1000000; j++){
                if(j%a==0 && j%b==0){
                    sb.append(j).append(' ');
                    break;
                }
            }
            for(int j=1000; j>=1; j--){
                if(a%j==0 && b%j==0){
                    sb.append(j).append('\n');
                    break;
                }
            }
        }
        System.out.print(sb);
    }
}
