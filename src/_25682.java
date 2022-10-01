import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _25682 {
    public static void main(String[] args) throws IOException {
        Init();
        //PrintMap();
        FillPrefixSum_Row();
        //PrintPrefixSum_Row();
        FillPrefixSum();
        //PrintPrefixSum();
        System.out.println(GetResult());
    }
    static int R,C,K;
    static boolean[][] Map;  // (0,0)이 B인 경우와 W인 경우
    public static void Init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        Map = new boolean[R][C];
        for(int r=0; r<R; r++){
            String str = br.readLine();
            for(int c=0; c<C; c++){
                char tmp = str.charAt(c);
                if( ((r+c)%2==0 && tmp=='B') || ((r+c)%2==1 && tmp=='W') ){
                    Map[r][c]=true;
                }
            }
        }
        PrefixSum_Row = new int[R][C-K+1];
        PrefixSum = new int[R-K+1][C-K+1];
    }
    static int[][] PrefixSum_Row, PrefixSum; // 행 누적합, 행렬 누적합
    public static void FillPrefixSum_Row(){
        for(int r=0; r<R; r++){
            for(int i=0; i<K; i++){
                PrefixSum_Row[r][0] += Map[r][i]?1:0;
            }
            for(int c=1; c<=C-K; c++){
                PrefixSum_Row[r][c] = PrefixSum_Row[r][c-1] - (Map[r][c-1]?1:0) + (Map[r][c-1+K]?1:0);
            }
        }
    }
    public static void FillPrefixSum(){
        for(int c=0; c<=C-K; c++){
            for(int i=0; i<K; i++){
                PrefixSum[0][c] += PrefixSum_Row[i][c];
            }
            for(int r=1; r<=R-K; r++){
                PrefixSum[r][c] = PrefixSum[r-1][c] - PrefixSum_Row[r-1][c] + PrefixSum_Row[r-1+K][c];
            }
        }
    }
    public static int GetResult(){
        int Square = K*K;
        int Min = Square;
        for(int r=0; r<=R-K; r++){
            for(int c=0; c<=C-K; c++){
                Min = Math.min(PrefixSum[r][c], Min);
                Min = Math.min(Square-PrefixSum[r][c], Min);
            }
        }
        return Min;
    }
    public static void PrintMap(){
        for(int r=0; r<R; r++){
            System.out.println();
            for(int c=0; c<C; c++){
                System.out.print(Map[r][c]?"  O":"  .");
            }
        }
        System.out.println();
    }
    public static void PrintPrefixSum_Row(){
        for(int r=0; r<R; r++){
            System.out.println();
            for(int c=0; c<=C-K; c++){
                System.out.printf("%3d",PrefixSum_Row[r][c]);
            }
        }
        System.out.println();
    }
    public static void PrintPrefixSum(){
        for(int r=0; r<=R-K; r++){
            System.out.println();
            for(int c=0; c<=C-K; c++){
                System.out.printf("%3d",PrefixSum[r][c]);
            }
        }
        System.out.println();
    }
}
