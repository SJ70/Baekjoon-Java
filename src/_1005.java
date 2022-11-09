import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _1005 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            init();
//            printMatrix();
//            printTree();
            TopologicalSort();
//            printMatrix();
//            printTree();
            sb.append(MinTimeToBuild(Arrival)).append('\n');
        }
        System.out.println(sb);
    }
    static int EdgeCnt, VortexCnt;
    static ArrayList<ArrayList<Integer>> BuildPrevious;
    static int[][] Matrix;
    static int[] BuildTime;
    static int[] Min_BuildTime;
    static int Arrival;
    static final int INFINITE = 999999;
    public static void init() throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        EdgeCnt = Integer.parseInt(st.nextToken());
        VortexCnt = Integer.parseInt(st.nextToken());
        BuildPrevious = new ArrayList<>();
        Matrix = new int[EdgeCnt+1][EdgeCnt+1];
        for(int r=1; r<=EdgeCnt; r++){
            for(int c=1; c<=EdgeCnt; c++){
                Matrix[r][c] = INFINITE;
            }
        }
        BuildTime = new int[EdgeCnt+1];
        Min_BuildTime = new int[EdgeCnt+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=EdgeCnt; i++){
            BuildTime[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<=EdgeCnt; i++){
            BuildPrevious.add(new ArrayList<>());
        }

        for(int i=1; i<=VortexCnt; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            Matrix[from][to] = 1;
            BuildPrevious.get(to).add(from);
        }

        Arrival = Integer.parseInt(br.readLine());
    }
    public static void TopologicalSort(){
        for(int across=1; across<=EdgeCnt; across++){
            for(int from=1; from<=EdgeCnt; from++){
                if(Matrix[from][across]==INFINITE) continue;
                for(int to=1; to<=EdgeCnt; to++){
                    if(Matrix[across][to]==INFINITE) continue;
                    Matrix[from][to] = Matrix[from][across] + Matrix[across][to];
                }
            }
        }
        for(int to=1; to<=EdgeCnt; to++){
            int loop = BuildPrevious.get(to).size() -1;
            for(int i=loop; i>=0; i--){
                int from = BuildPrevious.get(to).get(i);
//                System.out.printf("Matrix[%d][%d]=%d\n",from,to,Matrix[from][to]);
                if(Matrix[from][to]!=1){
                    BuildPrevious.get(to).remove(i);
                }
            }
        }
    }
    public static int MinTimeToBuild(int n){
        int MaxTime = 0;
        for(int element : BuildPrevious.get(n)){
            if(Min_BuildTime[element]==0)
                Min_BuildTime[element] = MinTimeToBuild(element);
            MaxTime = Math.max(MaxTime, Min_BuildTime[element]);
        }
        return BuildTime[n] + MaxTime;
    }
    public static void printMatrix(){
        for(int r=1; r<=EdgeCnt; r++){
            for(int c=1; c<=EdgeCnt; c++){
                System.out.printf("%7d",Matrix[r][c]);
            }
            System.out.println();
        }
    }
    public static void printTree(){
        for(int from=1; from<=EdgeCnt; from++){
            System.out.println(from);
            for(int to : BuildPrevious.get(from)){
                System.out.println("  <- "+to);
            }
        }
        System.out.println();
    }
}
