import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2559 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N,K;
    static int[] Arr;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Arr = new int[N+K+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            Arr[i] = Arr[i-1] + Integer.parseInt(st.nextToken());
        }

        int MaxResult = -10000000;
        for(int i=0; i<=N-K; i++){
            MaxResult = Math.max(MaxResult, Arr[i+K]-Arr[i]);
        }

        System.out.print(MaxResult);
    }
}
