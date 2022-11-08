import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// R로 시작할 때, B로 시작할 때, G으로 시작할 때의 배열을 각각 계산
public class _17404 {
    static int N;
    static int[][][] Cost;  // index, startColor, costPerColor
    static final int R = 0;
    static final int G = 1;
    static final int B = 2;
    static final int INFINITE = 9999;
    public static void main(String[] args) throws IOException{
        init();
        DP();
        //print();
        System.out.println(getMinResult());
    }
    public static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        Cost = new int[N][3][3];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int color=R; color<=B; color++){
                Cost[i][R][color] = Cost[i][G][color] = Cost[i][B][color] = Integer.parseInt(st.nextToken());
            }
        }
    }
    public static void DP(){
        for(int startColor=R; startColor<=B; startColor++){
            // 인덱스 0
            for(int color=R; color<=B; color++){
                if(color==startColor) continue;
                Cost[0][startColor][color] = INFINITE;
            }
            // 인덱스 1 ~ N-1
            for(int i=1; i<N; i++){
                for(int color=R; color<=B; color++){
                    insertValue(i,startColor,color);
                }
            }
            // 인덱스 N-1
            for(int color=R; color<=B; color++){
                Cost[N-1][color][color] = INFINITE;
            }
        }
    }
    public static void insertValue(int index, int startColor, int color){
        int color1 = (color==0) ? 2 : color-1;
        int color2 = (color==2) ? 0 : color+1;
        Cost[index][startColor][color] += Math.min(Cost[index-1][startColor][color1], Cost[index-1][startColor][color2]);
    }

    public static int getMinResult(){
        return Min(Min(R),Min(G),Min(B));
    }
    public static int Min(int color){
        int color1 = (color==0) ? 2 : color-1;
        int color2 = (color==2) ? 0 : color+1;
        return Math.min(Cost[N-1][color][color1], Cost[N-1][color][color2]);
    }
    public static int Min(int a, int b, int c){
        return Math.min(a, Math.min(b,c));
    }

    public static void print(){
        for(int i=0; i<N; i++){
            for(int startColor=R; startColor<=B; startColor++){
                for(int color=R; color<=B; color++){
                    if(Cost[i][startColor][color]>=INFINITE) System.out.print("   ∞");
                    else System.out.printf("%4d",Cost[i][startColor][color]);
                }
                System.out.print(" |");
            }
            System.out.println();
        }
    }
}
