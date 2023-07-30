import java.io.*;
import java.util.*;

public class _1197 {
    static int V, E;
    static int[] unionFind;

    private static class Edge{
        int v1, v2, dist;
        public Edge(int v1, int v2, int dist){
            this.v1 = v1;
            this.v2 = v2;
            this.dist = dist;
        }
    }
    static PriorityQueue<Edge> Edges = new PriorityQueue<>(Comparator.comparingInt(o -> o.dist));

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(getResult());;
    }
    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        unionFind = new int[V];
        for(int v=0; v<V; v++){
            unionFind[v] = v;
        }

        for(int e=0; e<E; e++){
            StringTokenizer edge = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(edge.nextToken()) - 1;
            int v2 = Integer.parseInt(edge.nextToken()) - 1;
            int dist = Integer.parseInt(edge.nextToken());
            Edges.add(new Edge(v1, v2, dist));
        }
    }

    private static int getResult(){
        int result = 0;
        while(!Edges.isEmpty()){
            Edge edge = Edges.poll();

            int group1 = unionFind[edge.v1];
            int group2 = unionFind[edge.v2];

            if(group1 != group2){
                int changeTarget = Math.max(group1, group2);
                int changeValue = Math.min(group1, group2);
                for(int i=0; i<V; i++){
                    if(unionFind[i] == changeTarget){
                        unionFind[i] = changeValue;
                    }
                }
                result += edge.dist;
            }
        }
        return result;
    }
}
