import java.io.*;
import java.util.*;

public class _23289 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int Chocolate = 0;
    public static void main(String[] args) throws IOException{
        Input();
        while(true){
            Operate();
            Adjust();
            MinusBorder();
            Chocolate++;
//            System.out.println(Chocolate);
//            Print();
            if(CheckEnd()) break;
            if(Chocolate==100){
                Chocolate=101; break;
            }
        }
        System.out.println(Chocolate);
    }
    static int R,C,K,W;
    static int[][] Map;
    static boolean[][][] Walls;
    static class data{
        int r,c,t,d;    // 좌표,온도,방향
        public data(int r, int c, int d, int t){
            this.r=r;
            this.c=c;
            this.d=d;
            this.t=t;
        }
        public data(int r, int c, int d){
            this.r=r;
            this.c=c;
            this.d=d;
        }
        public data(int r, int c){
            this.r=r;
            this.c=c;
        }
    }
    static ArrayList<data> Heater = new ArrayList<>();   // 온풍기
    static ArrayList<data> Measure = new ArrayList<>();   // 측정하는칸
    public static void Input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        Map = new int[R][C];
        Walls = new boolean[2][R][C];
        for(int r=0; r<R; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<C; c++){
                switch(Integer.parseInt(st.nextToken())){
                    case 1 : Heater.add(new data(r,c+1,0)); break;    //오른쪽
                    case 2 : Heater.add(new data(r,c-1,2)); break;    //왼쪽
                    case 3 : Heater.add(new data(r-1,c,3)); break;    //윗쪽
                    case 4 : Heater.add(new data(r+1,c,1)); break;    //아랫쪽
                    case 5 : Measure.add(new data(r,c)); break;
                    default: break;
                }
            }
        }
        W = Integer.parseInt(br.readLine());
        for(int i=0; i<W; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            Walls[d][ (d==0) ? r-2 : r-1 ][c-1] = true;
        }
    }
    static int[] dr = {0,1,0,-1};   // 우,하,좌,상
    static int[] dc = {1,0,-1,0};
    public static void Print(){
        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                if(Map[r][c]!=0) System.out.printf("%3d  ",Map[r][c]);
                else System.out.print("  .  ");
                System.out.print((Walls[1][r][c])?"|":" ");
            }
            System.out.println();
            for(int c=0; c<C; c++){
                System.out.print((Walls[0][r][c])?"-----+":"     +");
            }
            System.out.println();
        }
        System.out.println();
    }
    static Queue<data> Q = new ArrayDeque<>();
    public static void Operate(){
        for(int i=0; i<Heater.size(); i++){
            Q.add(new data(Heater.get(i).r, Heater.get(i).c, Heater.get(i).d, 5));
            boolean[][] Visited = new boolean[R][C];
            while(!Q.isEmpty()){
                data D = Q.poll();
                if( D.r<0 || D.r>=R || D.c<0 || D.c>=C || D.t==0 || Visited[D.r][D.c] )
                    continue;
                Map[D.r][D.c]+=D.t;
                Visited[D.r][D.c]=true;

                if( !isWall(D.r,D.c,D.d) )
                    Q.add(new data(D.r+dr[D.d],D.c+dc[D.d], D.d,D.t-1));

                int d2 = (D.d==0)? 3 : D.d-1;
                int r2 = D.r+dr[d2];
                int c2 = D.c+dc[d2];
                if( !isWall(r2,c2,D.d) && !isWall(D.r,D.c,d2) )
                    Q.add(new data(r2+dr[D.d],c2+dc[D.d], D.d,D.t-1));

                int d3 = (D.d==3)? 0 : D.d+1;
                int r3 = D.r+dr[d3];
                int c3 = D.c+dc[d3];
                if( !isWall(r3,c3,D.d) && !isWall(D.r,D.c,d3) )
                    Q.add(new data(r3+dr[D.d],c3+dc[D.d], D.d,D.t-1));
            }
        }
    }
    public static boolean isWall(int r, int c, int d){
        // #1:우[0] , #2:좌[2] , #3:상[3] , #4:하[1]
        if( r<0 || r>=R || c<0 || c>=C ) return true;
//        if(d==1) r--;
//        else if(d==0) c--;
        if(d==0) return Walls[1][r][c];
        else if(d==1) return Walls[0][r][c];
        else if(d==2){
            if(c-1<0) return false;
            else return Walls[1][r][c-1];
        }
        else if(d==3){
            if(r-1<0) return false;
            else return Walls[0][r-1][c];
        }
        else return false;
    }
    public static void Adjust(){
        int[][] Diff = new int[R][C];
        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                for(int d=0; d<4; d++){
                    int r2 = r+dr[d];
                    int c2 = c+dc[d];
                    if( r2>=0 && r2<R && c2>=0 && c2<C && !isWall(r,c,d) && Map[r][c]>Map[r2][c2] ) {
                        int n = (Map[r][c]-Map[r2][c2])/4;
                        Diff[r][c] -= n;
                        Diff[r2][c2] += n;
                    }
                }
            }
        }
        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                Map[r][c] += Diff[r][c];
            }
        }
    }
    public static void MinusBorder(){
        for(int r=0; r<R; r++){
            if(Map[r][0]>0) Map[r][0]--;
            if(Map[r][C-1]>0) Map[r][C-1]--;
        }
        for(int c=1; c<C-1; c++){
            if(Map[0][c]>0) Map[0][c]--;
            if(Map[R-1][c]>0) Map[R-1][c]--;
        }
    }
    static int index=0;
    public static boolean CheckEnd(){
        for(index=index; index<Measure.size(); index++){
            if(Map[Measure.get(index).r][Measure.get(index).c]<K) return false;
        }
        return true;
    }
}