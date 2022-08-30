import java.io.*;
import java.util.*;

public class _1260 {
    public static void main(String[] args) throws IOException{
        Init();

        visited = new boolean[N+1];
        DFS(V);
        bw.write("\n");

        visited = new boolean[N+1];
        Q.add(V);
        while(!Q.isEmpty()) BFS(Q.poll());

        bw.flush();
        bw.close();
    }
    static int N,M,V;
    static Node[] nodes;
    public static class Node{
        ArrayList<Integer> arr = new ArrayList<>();
    }
    public static void Init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        nodes = new Node[N+1];
        for(int i=1; i<=N; i++) nodes[i] = new Node();
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            nodes[a].arr.add(b);
            nodes[b].arr.add(a);
            //양방향
        }
        for(int i=1; i<=N; i++) Collections.sort(nodes[i].arr);
    }
    static boolean[] visited;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void DFS(int n) throws IOException{
        if(visited[n]) return;

        visited[n]=true;
        bw.write(n+" ");

        for(int i=0; i<nodes[n].arr.size(); i++)
            DFS(nodes[n].arr.get(i));
    }
    static Queue<Integer> Q = new ArrayDeque<>();
    public static void BFS(int n) throws IOException{
        if(visited[n]) return;

        visited[n]=true;
        bw.write(n+" ");

        Q.addAll(nodes[n].arr);
    }
}
