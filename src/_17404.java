import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _17404 {
    static int N;
    static int[][] Cost;
    static int[][] MinCostPerColor;
    static final int R = 0;
    static final int G = 1;
    static final int B = 2;
    public static void main(String[] args) throws IOException{
        init();
        DP();
        print(MinCostPerColor);
    }
    public static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        Cost = new int[N][3];
        MinCostPerColor = new int[N][3];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int color=R; color<=B; color++){
                Cost[i][color] = Integer.parseInt(st.nextToken());
            }
        }
    }
    public static void DP(){
        for(int color=R; color<=B; color++){
            MinCostPerColor[0][color] = Cost[0][color];
        }
    }
    public static void print(int[][] arr){
        for(int i=0; i<N; i++){
            for(int color=R; color<=B; color++){
                System.out.printf("%d ",Cost[i][color]);
            }
            System.out.println();
        }
    }
}
