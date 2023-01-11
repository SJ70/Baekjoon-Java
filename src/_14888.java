import java.util.*;
import java.io.*;

public class _14888 {
    public static void main(String[] args) throws IOException{
        init();
        bt(nums[0],1,SUM,SUB,MUL,DIV);
        System.out.printf("%d\n%d",Max,Min);
    }
    static int N;
    static int[] nums;
    static int SUM,SUB,MUL,DIV;
    static int Max = -2000000000;
    static int Min = 2000000000;
    public static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        nums = new int[N];
        for(int i=0; i<N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        SUM = Integer.parseInt(st.nextToken());
        SUB = Integer.parseInt(st.nextToken());
        MUL = Integer.parseInt(st.nextToken());
        DIV = Integer.parseInt(st.nextToken());
    }
    public static void bt(int num, int i, int sum, int sub, int mul, int div){
        if(i==N){
            Max = Math.max(Max,num);
            Min = Math.min(Min,num);
            return;
        }
        if(sum>0) bt(num + nums[i], i+1, sum-1, sub, mul, div);
        if(sub>0) bt(num - nums[i], i+1, sum, sub-1, mul, div);
        if(mul>0) bt(num * nums[i], i+1, sum, sub, mul-1, div);
        if(div>0) bt(num / nums[i], i+1, sum, sub, mul, div-1);
    }
}
