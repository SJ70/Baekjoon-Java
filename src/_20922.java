import java.io.*;
import java.util.*;

public class _20922 {
    public static void main(String[] args) throws IOException{
        init();
        System.out.println(solve());
    }
    static int N, K;
    static int[] NumCnt = new int[100001];
    static int[] Nums;
    public static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            Nums[i] = Integer.parseInt(st.nextToken());
        }
    }
    public static int solve(){
        int Max_Length = 1;
        int left = 0;
        int right = 0;
        NumCnt[Nums[0]]++;

        while(true){
            right++;
            if(right==N) break;
            NumCnt[Nums[right]]++;
            while(NumCnt[Nums[right]]>K){
                NumCnt[Nums[left]]--;
                left++;
            }
            Max_Length = Math.max(Max_Length, right-left+1);
        }
        return Max_Length;
    }
}
