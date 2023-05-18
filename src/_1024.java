import java.io.*;
import java.util.*;

public class _1024 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int min_length = Integer.parseInt(st.nextToken());
        for(int i=min_length; i<=100; i++){
            if(i%2==0){
                if(N%i==i/2){
                    int mid = N/i;
                    if(mid-i/2+1 < 0) continue;
                    for(int k=mid-i/2+1; k<=mid+i/2; k++){
                        sb.append(k).append(' ');
                    }
                    System.out.print(sb);
                    return;
                }
            }
            else{
                if(N%i==0){
                    int mid = N/i;
                    if(mid-i/2 < 0 ) continue;
                    for(int k=mid-i/2; k<=mid+i/2; k++){
                        sb.append(k).append(' ');
                    }
                    System.out.print(sb);
                    return;
                }
            }
        }
        System.out.println(-1);
    }
}
