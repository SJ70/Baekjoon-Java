import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10804 {
    public static void main(String[] args) throws IOException{
        int[] arr = new int[20];
        for(int i=0; i<20; i++){
            arr[i] = i+1;
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0; i<10; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken())-1;
            int B = Integer.parseInt(st.nextToken())-1;
            for(int k=0; A+k<B-k; k++){
                int tmp = arr[A+k];
                arr[A+k] = arr[B-k];
                arr[B-k] = tmp;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<20; i++){
            sb.append(arr[i]).append(' ');
        }
        System.out.println(sb);
    }
}
