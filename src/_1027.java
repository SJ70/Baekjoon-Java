import java.io.*;
import java.util.*;

public class _1027 {
    static int N;
    static int[] arr;
    static int result = 0;
    public static void main(String[] args) throws IOException{
        input();
        for(int i=0; i<N; i++){
//            System.out.printf("\n\n %d : \n",i);
            int cnt = countCanSee(i,-1)+countCanSee(i,+1);
            result = Math.max(result, cnt);
        }
//        System.out.println();
        System.out.println(result);
    }
    public static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
    public static int countCanSee(int index, int dir){
        int i = index+dir;
        int cnt = 0;
        double lastSlope = Double.MAX_VALUE;
        while(i>=0 && i<N){
            double currentSlope = (double)(arr[index]-arr[i]) / (double)Math.abs(index-i);
            if(lastSlope > currentSlope){
                lastSlope = currentSlope;
                cnt++;
//                System.out.printf("%d ",i);
            }
            i+=dir;
        }
        return cnt;
    }
}
