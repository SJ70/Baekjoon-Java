import java.io.*;
import java.util.*;

public class _1453 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] arr = new boolean[100];
        int cnt = 0;

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int n = Integer.parseInt(st.nextToken())-1;
            if(arr[n]){
                cnt++;
            }
            else{
                arr[n]=true;
            }
        }
        System.out.println(cnt);
    }
}
