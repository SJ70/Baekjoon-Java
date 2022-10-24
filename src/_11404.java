import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 플로이드 알고리즘
public class _11404 {
    static final int INFINITE = 2147483647;
    static int N;
    static int[][] M;
    public static void main(String[] args) throws IOException{
        init();
        floyd();
        printM();
    }
    public static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = new int[N][N];
        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                if(r==c) continue;
                M[r][c] = INFINITE;
            }
        }
        int VortexCnt = Integer.parseInt(br.readLine());
        for(int i=0; i<VortexCnt; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) -1;
            int to = Integer.parseInt(st.nextToken()) -1;
            int length = Integer.parseInt(st.nextToken());
            M[from][to] = Math.min(M[from][to], length);
        }
    }
    public static void printM(){
        StringBuilder sb = new StringBuilder();
        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                sb.append(M[r][c]==INFINITE?0:M[r][c]).append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
    public static void floyd(){
        for(int across=0; across<N; across++){
            for(int from=0; from<N; from++){
                if(across==from || M[from][across]==INFINITE) continue;
                for(int to=0; to<N; to++){
                    if(from==to || M[across][to]==INFINITE) continue;
                    M[from][to] = Math.min(M[from][to], M[from][across] + M[across][to]);
                }
            }
        }
    }
}
