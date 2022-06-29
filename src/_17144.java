import java.io.*;
import java.util.*;

public class _17144 {
    public static void main(String[] args) throws IOException {
        Input();
        for(int i=0; i<T; i++){
            Spread();
            //Print();
            Roll();
            //Print();
        }
        System.out.println(Total());
    }
    static int R,C,T, ACr;
    static int[][] Map;
    public static void Input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        Map = new int[R][C];
        for(int r=0; r<R; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<C; c++){
                int tmp = Integer.parseInt(st.nextToken());
                if(tmp==-1){
                    ACr=r;
                }
                if(tmp!=0){
                    Map[r][c] = tmp;
                }
            }
        }
    }
    public static void Spread(){
        Queue<Integer> Q = new ArrayDeque<>();
        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                int tmp = Map[r][c];
                int SpreadCnt = 0;
                if( r-1>=0 && Map[r-1][c]!=-1 ){
                    Q.add(r-1); Q.add( c ); Q.add(tmp/5); SpreadCnt++;
                }
                if( r+1<R && Map[r+1][c]!=-1 ){
                    Q.add(r+1); Q.add( c ); Q.add(tmp/5); SpreadCnt++;
                }
                if( c-1>=0 && Map[r][c-1]!=-1 ){
                    Q.add( r ); Q.add(c-1); Q.add(tmp/5); SpreadCnt++;
                }
                if( c+1<C && Map[r][c+1]!=-1 ){
                    Q.add( r ); Q.add(c+1); Q.add(tmp/5); SpreadCnt++;
                }
                if(SpreadCnt>0){
                    Q.add( r ); Q.add( c ); Q.add(-tmp/5 *SpreadCnt);
                }
            }
        }
        while(!Q.isEmpty()){
            Map[Q.poll()][Q.poll()]+=Q.poll();
        }
    }
    public static void Roll(){
        int ACr1 = ACr-1;
        for(int r=ACr1-1; r>=1; r--)
            Map[r][0]=Map[r-1][0];
        for(int c=0; c<=C-2; c++)
            Map[0][c]=Map[0][c+1];
        for(int r=0; r<=ACr1-1; r++)
            Map[r][C-1]=Map[r+1][C-1];
        for(int c=C-1; c>=2; c--)
            Map[ACr1][c]=Map[ACr1][c-1];
        Map[ACr1][1]=0;
        for(int r=ACr+1; r<=R-2; r++)
            Map[r][0]=Map[r+1][0];
        for(int c=0; c<=C-2; c++)
            Map[R-1][c]=Map[R-1][c+1];
        for(int r=R-1; r>=ACr+1; r--)
            Map[r][C-1]=Map[r-1][C-1];
        for(int c=C-1; c>=2; c--)
            Map[ACr][c]=Map[ACr][c-1];
        Map[ACr][1]=0;
    }
    public static int Total(){
        int result = 0;
        for(int r=0; r<R; r++)
            for(int c=0; c<C; c++)
                if(Map[r][c]>0)
                    result+=Map[r][c];
        return result;
    }
    public static void Print(){
        for(int r=0; r<R; r++){
            System.out.println();
            for(int c=0; c<C; c++){
                if(Map[r][c]==0) System.out.print("  .");
                else if(Map[r][c]==-1) System.out.print("  *");
                else System.out.printf("%3d",Map[r][c]);
            }
        }
        System.out.println();
    }
}
