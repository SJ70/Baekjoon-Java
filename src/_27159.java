import java.io.*;
import java.util.StringTokenizer;

public class _27159 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int score = 0;
        int value = 0;
        for(int i=N-1; i>=0; i--){
            if(arr[i] != value-1){
                score += value;
            }
            value = arr[i];
        }
        score += value;

        System.out.println(score);
    }
}
