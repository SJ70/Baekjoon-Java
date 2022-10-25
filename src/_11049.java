import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 행렬 곱셈 순서 알고리즘
public class _11049 {
    static final int INFINITE = 2147483647;
    static int N;
    static int[] sizes;
    static int[][] A;
    public static void main(String[] args) throws IOException{
        init();
        solve();
        //printA();
        System.out.print(A[0][N-1]);
    }
    public static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        sizes = new int[N+1];
        A = new int[N][N];
        StringTokenizer st = new StringTokenizer("");
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            sizes[i] = Integer.parseInt(st.nextToken());
        }
        sizes[N] = Integer.parseInt(st.nextToken());
        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                if(r>=c) continue;
                A[r][c] = INFINITE;
            }
        }
    }
    public static void solve(){
        for(int diag=1; diag<=N-1; diag++){
//            System.out.println("diag :"+diag);
            for(int from=0; from<N-diag; from++){
//                System.out.println("from :"+from);
                int to = from+diag;
                for(int i=0; i<diag; i++){
//                    System.out.printf("%d %d %d %d \n",from,from+i,from+1+i,to);
                    A[from][to] = Math.min(A[from][to], A[from][from+i] + A[from+1+i][to] + sizes[from]*sizes[from+1+i]*sizes[to+1]);
                }
            }
        }
    }
    public static void printA(){
        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                System.out.printf("%4d",A[r][c]);
            }
            System.out.println();
        }
    }
}