import java.io.*;
import java.util.StringTokenizer;

public class _2003 {
    static int N,M;
    static int[] Arr;
    public static void main(String[] args){
        init();
        int result = 0;
        for(int i=1; i<=N; i++){
            for(int j=0; j<i; j++){
                if(Arr[i]-Arr[j]==M){
                    result++;
                }
            }
        }
        System.out.println(result);
    }
    public static void init(){
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            Arr = new int[N+1];
            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=N; i++){
                Arr[i] = Arr[i-1] + Integer.parseInt(st.nextToken());
            }
        }
        catch(Exception e){
        }
    }
}