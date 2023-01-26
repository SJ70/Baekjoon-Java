import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _11057 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][10];
        for(int i=0; i<10; i++){
            arr[0][i] = 1;
        }
        for(int n=1; n<N; n++){
            for(int i=0; i<10; i++){
                for(int j=i; j<10; j++){
                    arr[n][j] += arr[n-1][i];
                    arr[n][j] %= 10007;
                }
            }
        }
        int sum = 0;
        for(int i=0; i<10; i++){
            sum += arr[N-1][i];
            sum %= 10007;
        }
        System.out.println(sum);
    }
}
