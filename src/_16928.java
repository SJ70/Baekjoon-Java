import java.io.*;
import java.util.*;

public class _16928 {
    static Integer[] JumpTo = new Integer[100];
    static boolean[] Visited = new boolean[100];
    static Queue<Integer> Q = new ArrayDeque<>();
    public static void main(String[] args) throws IOException{
        input();

        Q.add(0);
        Visited[0] = true;

        int jumpCnt = 0;
        try{
            while(!Q.isEmpty()){
                int repeat = Q.size();
                jumpCnt++;
//                System.out.printf("\n---%d---\n",jumpCnt);
                for(int i=0; i<repeat; i++){
                    bfs(Q.poll());
                }
            }
        }
        catch(Exception e){
            System.out.println(jumpCnt);
        }
    }
    public static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) -1;
            int to = Integer.parseInt(st.nextToken()) -1;
            JumpTo[from] = to;
        }
    }

    private static class FoundResult extends Exception{}
    public static void bfs(int i) throws FoundResult{
//        System.out.println(i);
        for(int d=6; d>=1; d--){
            int next = i+d;
            if(next==99) throw new FoundResult();
            if(next>=100) continue;

            if(JumpTo[next]!=null){
                next = JumpTo[next];
            }
            if(!Visited[next]) {
                Visited[next] = true;
                Q.add(next);
            }
        }
    }
}
