import java.io.*;
import java.util.*;

public class _3197 {
    public static void main(String[] args) throws IOException{
        Init();
        //PrintMap();
        int time = 0;
        while(true){
            DFS();
            //PrintMap();
            if(End) break;
            Melt();
            //PrintMap();
            time++;
        }
        System.out.println(time);
    }
    //초기화
    static int R,C;
    static char[][] Map;
    static Queue<Integer> IceQ = new ArrayDeque<>(); // 얼음
    static Queue<Integer> LQ = new ArrayDeque<>(); // 백조 A가 이동할 수 있는 칸
    public static void Init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        Map = new char[R][C];
        GonnaMelt = new boolean[R][C];
        for(int r=0; r<R; r++){
            String str = br.readLine();
            for(int c=0; c<C; c++){
                char tmp = str.charAt(c);
                if(tmp=='X'){
                    Map[r][c] = 'X';
                    IceQ.add(r); IceQ.add(c);
                }
                else if(tmp=='.'){
                    Map[r][c] = '.';
                }
                else if(tmp=='L'){
                    if(LQ.isEmpty()){
                        Map[r][c] = 'A';
                        LQ.add(r); LQ.add(c);
                    }
                    else{
                        Map[r][c] = 'B';
                    }
                }
            }
        }
    }
    //백조 A가 이동할 수 있는 칸 탐색
    static boolean End;
    static Queue<Integer> tmpQ = new ArrayDeque<>();
    public static void DFS(){
        while(!LQ.isEmpty()){
            int r = LQ.poll();
            int c = LQ.poll();
            if( r<0 || r>=R || c<0 || c>=C ) continue;
            VisitIfCan(r-1,c);
            VisitIfCan(r+1,c);
            VisitIfCan(r,c-1);
            VisitIfCan(r,c+1);
            //주변에 얼음이 있는 경우 다음 분기에 탐색
            if(IceNearby(r,c)){
                tmpQ.add(r); tmpQ.add(c);
            }
        }
        //다음 분기에 탐색을 시작할 칸
        while(!tmpQ.isEmpty()){
            LQ.add(tmpQ.poll());
        }
    }
    public static void VisitIfCan(int r, int c){
        if( r<0 || r>=R || c<0 || c>=C || Map[r][c]=='A' || End ) return;
        if( Map[r][c]=='.' ){
            Map[r][c]='A';
            LQ.add(r); LQ.add(c);
        }
        else if( Map[r][c]=='B' ){
            LQ.clear();
            tmpQ.clear();
            End = true;
        }
    }
    public static boolean IceNearby(int r, int c){
        if( r-1>=0 && Map[r-1][c]=='X' ) return true;
        if( r+1<R && Map[r+1][c]=='X' ) return true;
        if( c-1>=0 && Map[r][c-1]=='X' ) return true;
        if( c+1<C && Map[r][c+1]=='X' ) return true;
        return false;
    }
    //얼음 녹음
    static Queue<Integer> MeltQ = new ArrayDeque<>();
    static boolean[][] GonnaMelt;
    public static void Melt(){
        while(!IceQ.isEmpty()){
            int r = IceQ.poll();
            int c = IceQ.poll();
            if(Map[r][c]!='X') continue;
            if(WaterNearby(r,c)){
                MeltQ.add(r); MeltQ.add(c);
            }
        }
        while(!MeltQ.isEmpty()){
            int r = MeltQ.poll();
            int c = MeltQ.poll();
            Map[r][c] = '.';
            AddQifIce(r-1,c);
            AddQifIce(r+1,c);
            AddQifIce(r,c-1);
            AddQifIce(r,c+1);
        }
    }
    public static void AddQifIce(int r, int c){
        if( r>=0 && r<R && c>=0 && c<C && Map[r][c]=='X' && !GonnaMelt[r][c] ){
            IceQ.add(r); IceQ.add(c);
            GonnaMelt[r][c]=true;
        }
    }
    public static boolean WaterNearby(int r, int c){
        if( r-1>=0 && Map[r-1][c]!='X' ) return true;
        if( r+1<R && Map[r+1][c]!='X' ) return true;
        if( c-1>=0 && Map[r][c-1]!='X' ) return true;
        if( c+1<C && Map[r][c+1]!='X' ) return true;
        return false;
    }
    //출력(테스트)
    public static void PrintMap(){
        System.out.println();
        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                System.out.print(Map[r][c]);
            }
            System.out.println();
        }
        System.out.println("LQ:"+LQ.size()/2);
        System.out.println("IceQ:"+IceQ.size()/2);
    }
}
