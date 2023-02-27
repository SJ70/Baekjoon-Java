import java.io.*;
import java.util.*;

public class _1182 {
    static int N, target, result;
    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        result = 0;
        bt(0,0,0);
        System.out.println(result);
    }
    public static void bt(int index, int size, int sum){
        if(index==N) return;
        if(sum+arr[index] == target) result++;
        bt(index+1, size+1, sum+arr[index]);
        bt(index+1, size, sum);
    }
}
