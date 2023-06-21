import java.io.*;
import java.util.*;

public class _2309 {
    static int[] Arr = new int[9];
    static boolean[] Visited = new boolean[9];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0; i<9; i++){
            Arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(Arr);

        try{
            BFS(0,0,0);
        }
        catch(FoundResult e){
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<9; i++){
                if(Visited[i]){
                    sb.append(Arr[i]).append('\n');
                }
            }
            System.out.print(sb);
        }
    }
    public static class FoundResult extends Exception{}
    public static void BFS(int i, int sum, int cnt) throws FoundResult{
        if(cnt>7 || sum>100) return;
        if(cnt==7 && sum==100) throw new FoundResult();
        if(i==9) return;
        Visited[i] = true;
        BFS(i+1,sum+Arr[i],cnt+1);
        Visited[i] = false;
        BFS(i+1,sum,cnt);
    }
}
