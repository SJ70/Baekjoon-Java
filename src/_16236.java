import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class _16236 {
    static int Time = 0;
    public static void main(String[] args) throws IOException{
        Init();
        while(changed){
            //Print();
            changed = false;
            q.add(Sr); q.add(Sc); q.add(0);
            visited = new boolean[N][N];
            visited[Sr][Sc]=true;
            EatableR = 99;
            EatableC = 99;
            EatableDist = 999;
            while(!q.isEmpty()){
                FindSmallFishNearby(q.poll(),q.poll(),q.poll());
            }
            Eat(EatableR,EatableC,EatableDist);
        }
        //Print();
        System.out.println(Time);
    }
    static int N,Sr,Sc;
    static int Ssize = 2;
    static int Sgrow = 0;
    static int[][] Map;
    public static void Init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Map = new int[N][N];
        for(int r=0; r<N; r++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                int tmp = Integer.parseInt(st.nextToken());
                if(tmp==9){
                    Sr = r;
                    Sc = c;
                }
                else if(tmp>0){
                    Map[r][c] = tmp;
                }
            }
        }
    }
    static Queue<Integer> q = new ArrayDeque<>();
    static boolean[][] visited;
    static boolean changed = true;
    public static void FindSmallFishNearby(int r, int c, int dist){
        Visit(r-1,c,dist);
        Visit(r,c-1,dist);
        Visit(r,c+1,dist);
        Visit(r+1,c,dist);

        if( Map[r][c]>0 && Map[r][c]<Ssize ){
            if( (EatableR>r || (EatableR==r && EatableC>c)) && EatableDist>=dist ){
                //System.out.println(r+","+c+","+dist);
                EatableR = r;
                EatableC = c;
                EatableDist = dist;
            }
        }
    }
    static int EatableR,EatableC,EatableDist;
    public static void Eat(int r, int c, int dist){
        if(EatableR==99) return;
        Map[r][c]=0;
        Sgrow++;
        if(Sgrow==Ssize){
            Ssize++;
            Sgrow=0;
        }
        Sr=r;
        Sc=c;
        changed = true;
        Time += dist;
        q.clear();
    }
    public static void Visit(int r, int c, int dist){
        if( r<0 || r>=N || c<0 || c>=N || visited[r][c] || Map[r][c]>Ssize || dist>=EatableDist ) return;
        visited[r][c]=true;
        q.add(r); q.add(c); q.add(dist+1);
    }
    public static void Print(){
        System.out.printf("%ds %d/%d\n",Time,Sgrow,Ssize);
        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                if(r==Sr && c==Sc) System.out.print(" *");
                else if(Map[r][c]==0) System.out.print(" .");
                else System.out.printf("%2d",Map[r][c]);
            }
            System.out.println();
        }
        System.out.println();
    }
}