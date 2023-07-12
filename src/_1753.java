import java.io.*;
import java.util.*;

public class _1753 {

    static int V, E;
    static int startEdge;
    static ArrayList<Edge>[] vortex_edges;
    static PriorityQueue<BFS_element> BFS_queue = new PriorityQueue<>();
    static int dist[];

    private static class Edge{
        int to, distance;
        public Edge(int to, int dist){
            this.to = to;
            this.distance = dist;
        }
    }

    private static class BFS_element implements Comparable<BFS_element>{
        int pos, distance;
        public BFS_element(int pos, int dist){
            this.pos = pos;
            this.distance = dist;
        }
        public int compareTo(BFS_element target){
            return this.distance - target.distance;
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        BFS();
        printResult();
    }

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        vortex_edges = new ArrayList[V];
        for(int i=0; i<V; i++){
            vortex_edges[i] = new ArrayList<>();
        }

        startEdge = Integer.parseInt(br.readLine()) -1;

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) -1;
            int to = Integer.parseInt(st.nextToken()) -1;
            int distance = Integer.parseInt(st.nextToken());
            Edge e = new Edge(to, distance);
            vortex_edges[from].add(e);
        }

        dist = new int[V];
        for(int i=0; i<V; i++){
            dist[i] = Integer.MAX_VALUE;
        }
    }

    private static void BFS(){
        BFS_queue.add(new BFS_element(startEdge, 0));
        dist[startEdge] = 0;
        while(!BFS_queue.isEmpty()){
            BFS_element element = BFS_queue.poll();
            for(Edge edge : vortex_edges[element.pos]){
                int to = edge.to;
                int d = edge.distance + element.distance;
                if(dist[to] > d){
                    dist[to] = d;
                    BFS_queue.add(new BFS_element(to, d));
                }
            }
        }
    }


    private static void printResult(){
        StringBuilder sb = new StringBuilder();
        for(int d : dist){
            sb.append(d == Integer.MAX_VALUE ? "INF" : d).append('\n');
        }
        System.out.print(sb);
    }
}
