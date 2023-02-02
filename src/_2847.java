import java.io.*;

public class _2847 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] Arr = new int[N];
        for(int i=0; i<N; i++){
            Arr[i] = Integer.parseInt(br.readLine());
        }
        int result = 0;
        for(int i=N-2; i>=0; i--){
            if(Arr[i]>=Arr[i+1]){
                int tmp = Arr[i]-Arr[i+1]+1;
                Arr[i] -= tmp;
                result += tmp;
            }
        }
        System.out.println(result);
    }
}
