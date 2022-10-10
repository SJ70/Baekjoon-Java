import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9095 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int[] arr;
    public static void main(String[] args) throws IOException{
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            int N = Integer.parseInt(br.readLine());
            sb.append(GetResult(N)+"\n");
        }
        System.out.println(sb);
    }
    public static int GetResult(int N){
        arr = new int[N+4];
        arr[0] = 1;
        for(int i=0; i<=N-1; i++){
            arr[i+1] += arr[i];
            arr[i+2] += arr[i];
            arr[i+3] += arr[i];
        }
        return arr[N];
    }
}
