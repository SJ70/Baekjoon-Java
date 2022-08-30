import java.util.*;
import java.io.*;

public class _2606 {
    public static void main(String[] args) throws IOException{
        Init();
        Q.add(0);
        while(!Q.isEmpty()){
            corrupt(Q.poll());
        }
        System.out.println(Result-1);
    }
    static int N,M;
    static Node[] nodes;
    public static class Node{
        ArrayList<Integer> arr = new ArrayList<>();
    }
    public static void Init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nodes = new Node[N];
        visited = new boolean[N];
        for(int i=0; i<N; i++){
            nodes[i] = new Node();
        }
        M = Integer.parseInt(br.readLine());
        for(int i=0; i<M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) -1;
            int b = Integer.parseInt(st.nextToken()) -1;
            nodes[a].arr.add(b);
            nodes[b].arr.add(a);
        }
    }
    static Queue<Integer> Q = new ArrayDeque<>();
    static int Result = 0;
    static boolean[] visited;
    public static void corrupt(int n){
        if(visited[n]) return;
        visited[n]=true;
        Result++;
        for(int i=0; i<nodes[n].arr.size(); i++){
            Q.add(nodes[n].arr.get(i));
        }
    }
}