import java.io.*;
import java.util.*;

public class _21772 {
    public static void main(String[] args) throws IOException{
        Input();
        Visited[Gr][Gc]=1;
        BF(Gr,Gc,1,0);
        System.out.println(Max_Result-1);
    }
    static int R,C,T;
    static String[] Map;
    static int [][] Visited;
    static int Gr,Gc;
    static int Max_Result = 1;
    public static void Input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        Map = new String[R];
        Visited = new int[R][C];
        for(int r=0; r<R; r++){
            Map[r] = br.readLine();
            for(int c=0; c<C; c++){
                if(Map[r].charAt(c)=='G'){
                    Gr=r; Gc=c;
                }
            }
        }
    }
    public static void BF(int r, int c, int score, int time){
        //test_print();
        //System.out.printf("%d: %2d,%2d, %d개\n",time,r,c,score);
        if(time==T){
            Max_Result = Math.max(Max_Result,score);
        }
        else{
            time++;
            Visit(r-1,c,score,time);
            Visit(r+1,c,score,time);
            Visit(r,c-1,score,time);
            Visit(r,c+1,score,time);
        }
    }
    public static void Visit(int r, int c, int score, int time){
        // 범위 / 벽 / 같은 점수로 이미 갔던 자리에는 다시 가지 않음
        // Visited 배열의 초깃값은 0이므로 score의 초깃값이 0일 경우 시작부터 움직이지 않는 문제 발생 --> score 초깃값:1
        if( r>=0 && r<R && c>=0 && c<C && Map[r].charAt(c)!='#' && Visited[r][c]!=score ){
            if(Map[r].charAt(c)=='S' && Visited[r][c]==0){ // 한 번도 방문하지 않은 자리에 고구마가 있을 경우
                score++;
            }
            int tmp = Visited[r][c];
            Visited[r][c]=score;
            BF(r,c,score,time);
            Visited[r][c]=tmp;
        }
    }
    public static void test_print(){
        System.out.println();
        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                System.out.print(Map[r].charAt(c)+""+Visited[r][c]+" ");
            }
            System.out.println();
        }
    }
}