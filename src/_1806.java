import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1806 {
    static int N, target;
    static int[] arr;
    public static void main(String[] args) throws IOException{
        try{
            Init();
            for(int i=1; i<N; i++){
                BS(i,i+1,N);
            }
            System.out.print(ResultMin);
        }
        catch(Exception e){
        }
    }
    public static void Init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());

        arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            int Num = Integer.parseInt(st.nextToken());
            arr[i] = arr[i-1] + Num;
            //System.out.println(arr[i]);
            if(Num>=target){
                System.out.print(1);
                throw new Exception();
            }
        }
        if(arr[N]<target){
            System.out.print(0);
            throw new Exception();
        }
    }
    public static int CumulativeSum(int left, int right){
        return arr[right]-arr[left-1];
    }
    static int ResultMin = 100000;
    public static void BS(int start, int left, int right){
        //System.out.println(start+":"+left+"~"+right+":"+(right-start+1));
        int mid = (left+right)/2;
        int ToMid = CumulativeSum(start,mid);
        int ToLeft = CumulativeSum(start,left);
        int ToRight = CumulativeSum(start,right);
        if(ToRight<target) return;
        if(left==right){
            ResultMin = Math.min(ResultMin, right-start+1);
            return;
        }
        if(ToMid>=target) BS(start,left,mid);
        else BS(start,mid+1,right);
    }
}
