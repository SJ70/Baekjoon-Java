import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _18111 {
    public static void main(String[] args) throws IOException{
        Init();
        DP();
        System.out.println(GetResult());
    }
    static int N, BlockInInventory;
    static int HIGHEST_HEIGHT = 256;
    static int[] Ground = new int[HIGHEST_HEIGHT+2];
    static int[] Air = new int[HIGHEST_HEIGHT+1];
    static int[] NeedToDig = new int[HIGHEST_HEIGHT+2];
    static int[] NeedToFill = new int[HIGHEST_HEIGHT+1];
    public static void Init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        N = R*C;
        BlockInInventory = Integer.parseInt(st.nextToken());
        for(int r=0; r<R; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<C; c++){
                int Height = Integer.parseInt(st.nextToken());
                Ground[Height]++;
            }
        }
    }
    public static void DP(){
        for(int i=HIGHEST_HEIGHT; i>0; i--){
            Ground[i-1] += Ground[i];
        }
        for(int i=HIGHEST_HEIGHT; i>0; i--){
            if(Ground[i]==0){
                HIGHEST_HEIGHT = i-1;
                continue;
            }
            Air[i] = N - Ground[i];
        }

        for(int i=HIGHEST_HEIGHT; i>=0; i--){
            NeedToDig[i] = NeedToDig[i+1]+Ground[i+1];
        }
        for(int i=1; i<=HIGHEST_HEIGHT; i++){
            NeedToFill[i] = NeedToFill[i-1]+Air[i];
        }
//        System.out.printf(" i : dirt  dig  air fill\n");
//        for(int i=0; i<=HIGHEST_HEIGHT; i++){
//            System.out.printf("%2d :%5d%5d%5d%5d\n",i,Ground[i],NeedToDig[i],Air[i],NeedToFill[i]);
//        }
    }
    public static String GetResult(){
        int Min_Time = -1;
        int Height = -1;
        for(int i=HIGHEST_HEIGHT; i>=0; i--){
            if( NeedToDig[i] + BlockInInventory >= NeedToFill[i] ){
                int Time = NeedToDig[i]*2 + NeedToFill[i];
                if(Min_Time==-1 || Time<Min_Time){
                    Min_Time = Time;
                    Height = i;
                }
            }
        }
        return (Min_Time+" "+Height);
    }
}