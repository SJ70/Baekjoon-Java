import java.util.*;
import java.io.*;

public class _6603 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int n;
    public static void main(String[] args) throws IOException{
        while(true){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            if(n==0) break;
            Solve();
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
    static ArrayList<Integer> arr;
    static boolean[] visited;
    public static void Solve() throws IOException{
        arr = new ArrayList<>();
        visited = new boolean[n];
        for(int i=0; i<n; i++){
            arr.add(Integer.parseInt(st.nextToken()));
        }
        BT(0,0);
    }
    public static void BT(int index, int cnt) throws IOException{
        if(cnt==6){
            for(int i=0; i<n; i++){
                if(visited[i]) bw.write(arr.get(i)+" ");
            }
            bw.write("\n");
            return;
        }
        if(index>=n) return;
        visited[index] = true;
        BT(index+1,cnt+1);
        visited[index] = false;
        BT(index+1,cnt);
    }
}
