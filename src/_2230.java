import java.util.*;
import java.io.*;

public class _2230 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int left = 0;
        int right = 1;
        int MinSub = Integer.MAX_VALUE;
        while(right<N){
//            System.out.println(arr[left]+" , "+arr[right]);
            int sub = arr[right] - arr[left];
            if(sub>=M){
                MinSub = Math.min(MinSub, sub);
                if(sub==M) break;
                left++;
                if(left==right) right++;
            }
            else{
                right++;
            }
        }
        System.out.println(MinSub);
    }
}
