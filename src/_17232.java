import java.io.*;
import java.util.*;

public class _17232 {
    public static void main(String[] args) throws IOException{
        Init();
        for(int i=0; i<TIME; i++){
            SetCumulativeSum();
//            Print(CumulativeSum_Row);
//            Print(CumulativeSum);
//            Print(Map);
            Observe();
            ApplyChange();
        }
        Print(Map);
    }
    static int R,C,TIME,RANGE,A,B;
    static boolean[][] Map;
    static int[][] CumulativeSum_Row,CumulativeSum;
    public static void Init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        TIME = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        RANGE = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        Map = new boolean[R][C];
        for(int r=0; r<R; r++){
            String str = br.readLine();
            for(int c=0; c<C; c++){
                Map[r][c] = str.charAt(c)=='*';
            }
        }
    }
    public static void SetCumulativeSum(){
        CumulativeSum_Row = new int[R][C];
        for(int r=0; r<R; r++){
            for(int c=0; c<=RANGE; c++){
                if(c>=C) continue;
                CumulativeSum_Row[r][0] += Map[r][c] ? 1 : 0;
            }
            for(int c=1; c<C; c++){
                CumulativeSum_Row[r][c] = CumulativeSum_Row[r][c-1];
                if(c+RANGE < C) {
                    CumulativeSum_Row[r][c] += (Map[r][c+RANGE] ? 1 : 0);
                }
                if(c-RANGE-1 >= 0){
                    CumulativeSum_Row[r][c] -= (Map[r][c-RANGE-1] ? 1 : 0);
                }
            }
        }

        CumulativeSum = new int[R][C];
        for(int c=0; c<C; c++){
            for(int r=0; r<=RANGE; r++){
                if(r>=R) continue;
                CumulativeSum[0][c] += CumulativeSum_Row[r][c];
            }
            for(int r=1; r<R; r++){
                CumulativeSum[r][c] = CumulativeSum[r-1][c];
                if(r+RANGE < R) {
                    CumulativeSum[r][c] += CumulativeSum_Row[r+RANGE][c];
                }
                if(r-RANGE-1 >= 0){
                    CumulativeSum[r][c] -= CumulativeSum_Row[r-RANGE-1][c];
                }
            }
        }
    }
    static Queue<Integer> ChangeQ = new ArrayDeque<>();
    public static void Observe(){
        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                if(isGonnaDead(r,c) || isGonnaBorn(r,c)){
                    ChangeQ.add(r);
                    ChangeQ.add(c);
                }
            }
        }
    }
    public static boolean isGonnaDead(int r, int c){
        return Map[r][c] && (CumulativeSum[r][c]-1<A || CumulativeSum[r][c]-1>B);
    }
    public static boolean isGonnaBorn(int r, int c){
        return !Map[r][c] && CumulativeSum[r][c]>A && CumulativeSum[r][c]<=B;
    }
    public static void ApplyChange(){
        while(!ChangeQ.isEmpty()){
            int r = ChangeQ.poll();
            int c = ChangeQ.poll();
            Map[r][c] = !Map[r][c];
        }
    }
    public static void Print(boolean[][] Arr){
        StringBuilder sb = new StringBuilder();
        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                sb.append(Arr[r][c]?'*':'.');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
    public static void Print(int[][] Arr){
        StringBuilder sb = new StringBuilder();
        sb.append("\n\n");
        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                sb.append(Arr[r][c]+" ");
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}