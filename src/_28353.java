import java.io.*;
import java.util.*;

public class _28353 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] CATS = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            CATS[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(CATS);

        int result = 0;
        int left = 0;
        int right = N-1;
        while(left<right){
            if(CATS[left] + CATS[right] <= K){
                result++;
                left++;
                right--;
            }
            else{
                right--;
            }
        }

        System.out.println(result);
    }
}
