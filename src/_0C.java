import java.io.*;
import java.util.*;

public class _0C {
    static int N, needToTired;
    static ArrayList<Integer> diff = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        int[] arr = input();

        if((N==needToTired) || (N==1 && needToTired==0)){
            System.out.println(0);
            return;
        }

        for(int i=0; i<N; i++){
            diff.add(maxDiffNearby(arr, i));
        }
        Collections.sort(diff);

//        System.out.println(diff);
        System.out.println( diff.get(N-needToTired-1) );
    }
    public static int[] input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        needToTired = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        return arr;
    }
    public static int maxDiffNearby(int[] arr, int i){
        int left = i==0 ? Integer.MIN_VALUE : Math.abs(arr[i]-arr[i-1]);
        int right = i==N-1 ? Integer.MIN_VALUE : Math.abs(arr[i]-arr[i+1]);
        return Math.max(left,right);
    }
}
