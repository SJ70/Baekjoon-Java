import java.io.*;
import java.util.*;

public class _11047 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int result = 0;
        int[] Coin = new int[N];
        for(int i=0; i<N; i++)
            Coin[i] = Integer.parseInt(br.readLine());
        for(int i=N-1; i>=0; i--){
            if( K >= Coin[i] ){
                result += K/Coin[i];
                K %= Coin[i];
            }
        }
        System.out.println(result);
    }
}
