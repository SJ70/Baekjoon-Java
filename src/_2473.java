import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class _2473 {
    static ArrayList<Long> Arr = new ArrayList<>();
    static int N;
    static boolean foundZero = false;
    static long[] smallestSum; // value,i1,i2,i3
    public static void main(String[] args) throws IOException{
        init();
        for(int i=0; i<N; i++){
            find(i);
            if(foundZero) break;
        }
        System.out.printf("%d %d %d",smallestSum[1],smallestSum[2],smallestSum[3]);
    }
    public static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            Arr.add(Long.parseLong(st.nextToken()));
        }
        Collections.sort(Arr);
        smallestSum = new long[4];
        smallestSum[0] = 4000000000L;
    }
    public static void find(int index){
        long target = Arr.get(index);
        int left = index+1;
        int right = N-1;
        while(left<right){
            long sum = target + Arr.get(left) + Arr.get(right);
            if(Math.abs(sum) < smallestSum[0]){
                smallestSum[0] = Math.abs(sum);
                smallestSum[1] = target;
                smallestSum[2] = Arr.get(left);
                smallestSum[3] = Arr.get(right);
            }
//            System.out.printf("%d %d %d\n",target, Arr.get(left), Arr.get(right));
            if(sum==0){
                foundZero = true;
                return;
            }
            else if(sum>0){
                right--;
            }
            else{//if(sum<0)
                left++;
            }
        }
    }
}
