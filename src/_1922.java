import java.io.*;
import java.util.*;

public class _1922 {

    private static class Route{
        int from, to, distance;
        public Route(int from, int to, int distance){
            this.from = from;
            this.to = to;
            this.distance = distance;
        }
    }

    static int V, E;
    static PriorityQueue<Route> PQ = new PriorityQueue<>(Comparator.comparingInt(route -> route.distance));
    static int[] UnionFind;
    static int ResultDistance = 0;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        System.out.println(ResultDistance);
    }

    private static void solve(){
        while(!PQ.isEmpty()){
            Route R = PQ.poll();
            int v1 = UnionFind[R.from];
            int v2 = UnionFind[R.to];

            int r1 = getRoot(v1);
            int r2 = getRoot(v2);

            if(r1 != r2){
                int rLow = Math.min(r1, r2);
                int rHigh = Math.max(r1, r2);

                UnionFind[rHigh] = rLow;
                ResultDistance += R.distance;
            }
        }
    }

    private static int getRoot(int i){
            return (UnionFind[i]==i) ? i : getRoot(UnionFind[i]);
    }

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        V = Integer.parseInt(br.readLine());

        UnionFind = new int[V];
        for(int v=0; v<V; v++){
            UnionFind[v] = v;
        }

        E = Integer.parseInt(br.readLine());

        for(int e=0; e<E; e++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken()) -1;
            int v2 = Integer.parseInt(st.nextToken()) -1;
            int distance = Integer.parseInt(st.nextToken());

            PQ.add(new Route(v1, v2, distance));
        }
    }
}
