import java.io.*;
import java.util.*;

public class _2116 {
    public static void main(String[] args) throws IOException{
        Input();
        for(int i=0; i<6; i++)
            Calc(0, i,0);
        System.out.println(Result_Max);
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[][] dice;
    public static void Input() throws IOException{
        N = Integer.parseInt(br.readLine());
        dice = new int[N][6];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int k=0; k<6; k++){
                dice[i][k] = Integer.parseInt(st.nextToken());
            }
        }
    }
    static int Result_Max = -1;
    public static void Calc(int index, int bottom, int sum){
        int topIndex = GetTopIndex(bottom);
        sum += GetSideMax(index,bottom);
        //System.out.printf("#%d, 밑면:%d, 윗면:%d, 옆면Max:%d, 누적합:%d \n",index+1,dice[index][bottom],dice[index][topIndex],GetSideMax(index,bottom),sum);
        if(index+1==N)
            Result_Max = Math.max(Result_Max,sum);
        else
            Calc(index+1, SearchBottomIndex(index+1, dice[index][topIndex]), sum);
    }
    public static int GetTopIndex(int bottom){
        switch(bottom){
            case 0: return 5;
            case 1: return 3;
            case 2: return 4;
            case 3: return 1;
            case 4: return 2;
            case 5: return 0;
            default: return -1;
        }
    }
    public static int GetSideMax(int index, int bottom){
        switch(bottom){
            case 0: case 5: return Max(dice[index][1],dice[index][2],dice[index][3],dice[index][4]);
            case 1: case 3: return Max(dice[index][0],dice[index][2],dice[index][4],dice[index][5]);
            case 2: case 4: return Max(dice[index][0],dice[index][1],dice[index][3],dice[index][5]);
            default: return -1;
        }
    }
    public static int Max(int a, int b, int c, int d) {
        return Math.max( Math.max(a,b) , Math.max(c,d) );
    }
    public static int SearchBottomIndex(int index, int N){
        for(int i=0; i<6; i++)
            if(dice[index][i]==N) return i;
        return -1;
    }
}
