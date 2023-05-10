import java.io.*;
import java.util.*;

public class _2644 {
    static int N, A, B;
    static ArrayList<Integer>[] Relation;
    public static void main(String[] args) throws IOException{
        init();
        System.out.println(bfs());
    }
    public static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Relation = new ArrayList[N];
        for(int i=0; i<N; i++){
            Relation[i] = new ArrayList<Integer>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken()) -1;
        B = Integer.parseInt(st.nextToken()) -1;

        int K = Integer.parseInt(br.readLine());

        for(int k=0; k<K; k++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) -1;
            int b = Integer.parseInt(st.nextToken()) -1;
            Relation[a].add(b);
            Relation[b].add(a);
        }
    }
    public static int bfs(){
        boolean[] Visited = new boolean[N];
        Queue<Integer> q = new ArrayDeque<>();
        q.add(A);

        int dist = 0;
        while(!q.isEmpty()){
            dist++;
            int repeat = q.size();
            for(int r=0; r<repeat; r++){
                int k = q.poll();
                Visited[k] = true;
                for(int e : Relation[k]){
                    if(!Visited[e]){
                        if(e==B) return dist;
                        else q.add(e);
                    }
                }
            }
        }
        return -1;
    }
}
