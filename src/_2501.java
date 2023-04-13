import java.io.*;
import java.util.*;

public class _2501 {
    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        for(int i=1; i<=N; i++){
            if(N%i==0){
                if(--K==0){
                    System.out.println(i);
                    return;
                }
            }
        }
        System.out.println(0);
    }
}
