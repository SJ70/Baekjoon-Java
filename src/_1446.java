import java.io.*;
import java.util.*;

public class _1446 {
    static int D;
    static int[] arr;
    static ArrayList<int[]>[] shortcut;
    public static void main(String[] args) throws IOException{
        init();
        for(int i=0; i<D; i++){
            for(int[] sc : shortcut[i]){
                int to = sc[0];
                int dist = sc[1];
                arr[to] = Math.min(arr[i]+dist, arr[to]);
            }
            arr[i+1] = Math.min(arr[i]+1, arr[i+1]);
        }
//        for(int i=0; i<=D; i++){
//            System.out.printf("%d : %d \n",i,arr[i]);
//        }
        System.out.println(arr[D]);
    }
    public static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        arr = new int[D+1];
        for(int i=1; i<=D; i++){
            arr[i] = Integer.MAX_VALUE;
        }
        shortcut = new ArrayList[D+1];
        for(int i=0; i<=D; i++){
            shortcut[i] = new ArrayList<>();
        }

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            if(to>D) continue;
            shortcut[from].add(new int[]{ to,dist });
        }
    }
}
