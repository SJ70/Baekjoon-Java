import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class _2140 {
    public static void main(String[] args) throws IOException{
        Init();
        QAdd(0,0);
        QAdd(0,N-1);
        QAdd(N-1,0);
        QAdd(N-1,N-1);
        while(!q.isEmpty()){
            SetMine(q.poll(),q.poll());
        }
        //PrintMap();
        int Inside = N>=5 ? (N-4)*(N-4) : 0;
        System.out.println(Result+Inside);
    }
    static int N;
    static char[][] Map;
    static boolean[][] Visited;
    static Queue<Integer> q = new ArrayDeque<>();
    public static void Init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Map = new char[N][N];
        Visited = new boolean[N][N];
        for(int r=0; r<N; r++){
            String str = br.readLine();
            for(int c=0; c<N; c++){
                Map[r][c] = str.charAt(c);
                if(r>=1 && r<=N-2) c+=N-2; // 배열 중간은 건너뜀
            }
        }
    }
    public static void SetMine(int r, int c){
        if(isEdge(r,c)){
            if(Map[r][c]=='0') SetAllNearby(r,c,false);
            else SetAllNearby(r,c,true);
        }
        else{
            int[] info = InfoNearby(r,c);
            //System.out.printf("\n(%d,%d) : [지뢰:%d, 공백:%d, 미지수:%d]",r,c,info[0],info[1],info[2]);
            if(info[2]==0) return;
            if( Map[r][c]-'0' == info[0] ) SetAllNearby(r,c,false);
            else SetAllNearby(r,c,true);
        }
        //PrintMap();
        QAdd(r-1,c);
        QAdd(r+1,c);
        QAdd(r,c-1);
        QAdd(r,c+1);
    }
    public static void QAdd(int r, int c){
        if( r<0 || r>=N || c<0 || c>=N || Visited[r][c] ) return;
        if( r>=1 && r<=N-2 && c>=1 && c<=N-2 ) return;
        q.add(r); q.add(c);
        Visited[r][c] = true;
    }
    static int Result = 0;
    public static void SetAllNearby(int R, int C, boolean mine){
        for(int r=R-1; r<=R+1; r++){
            if(r<0 || r>=N) continue;
            for(int c=C-1; c<=C+1; c++){
                if(c<0 || c>=N) continue;
                if(Map[r][c]=='\0'){
                    if(mine){
                        Map[r][c]='*';
                        Result++;
                    }
                    else Map[r][c]='.';
                }
            }
        }
    }
    public static int[] InfoNearby(int R, int C){
        int[] tmp = new int[3]; // '*', '.', '\n'
        for(int r=R-1; r<=R+1; r++){
            if(r<0 || r>=N) continue;
            for(int c=C-1; c<=C+1; c++){
                if(c<0 || c>=N) continue;
                if(Map[r][c]=='*') tmp[0]++;
                else if(Map[r][c]=='.') tmp[1]++;
                else if(Map[r][c]=='\0') tmp[2]++;
            }
        }
        return tmp;
    }
    public static boolean isEdge(int r, int c){
        return (r==0||r==N-1) && (c==0||c==N-1);
    }
    public static void PrintMap(){
        System.out.println();
        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                System.out.print(Map[r][c]!='\0'?Map[r][c]:" ");
            }
            System.out.println();
        }
    }
}