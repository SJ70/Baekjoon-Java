import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2467 {
    static int N;
    static int[] Arr;
    static int ResultLeft, ResultRight, SumMin;
    public static void main(String[] args) throws IOException{
        init();
        Compare(0,N-1);

        StringBuilder sb = new StringBuilder();
        sb.append(Arr[ResultLeft]).append(' ').append(Arr[ResultRight]);
        System.out.println(sb);
    }
    public static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            Arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(Arr);
        SumMin = 2100000000;
    }
    public static void Compare(int left, int right){
        int sum = Arr[left] + Arr[right];
        if(SumMin > Math.abs(sum)){
            ResultLeft = left;
            ResultRight = right;
            if(sum==0) return;
            SumMin = Math.abs(sum);
        }
        if(sum<0) left++;
        else right--;

        if(left==right) return;
        Compare(left,right);
    }
}
