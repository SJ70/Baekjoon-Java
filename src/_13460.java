import java.util.*;
import java.io.*;

public class _13460 {
    static int N,M;
    static char[][] Map;
    static ArrayList<RC> Record = new ArrayList<>(); // 이전 좌표를 저장
    static Queue<Data> q = new ArrayDeque<>();
    static boolean success = false;
    public static class RC{
        int Rr,Rc,Br,Bc;
        public RC(){}
        public RC(Data D){
            this.Rr=D.Rr; this.Rc=D.Rc; this.Br=D.Br; this.Bc=D.Bc;
        }
    }
    public static class Data extends RC{
        int cnt = 0;
        String p = "";
        public Data(){}
        public Data(Data D){
            this.Rr=D.Rr; this.Rc=D.Rc; this.Br=D.Br; this.Bc=D.Bc; this.p=D.p; this.cnt=D.cnt+1;
        }
        public Data(int Rr, int Rc, int Br, int Bc, char C){
            this.Rr=Rr; this.Rc=Rc; this.Br=Br; this.Bc=Bc; this.p+=C;
        }
    }
    public static void main(String[] args) throws IOException{
        BFS(Input());
    }
    public static Data Input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Map = new char[N][M];
        Data D = new Data();
        for(int r=0; r<N; r++){
            String str = br.readLine();
            for(int c=0; c<M; c++){
                char C = str.charAt(c);
                Map[r][c] = (C=='#'||C=='O') ? C : '.' ; // 벽과 구멍을 제외하고 모두 빈 공간으로 입력
                if(C=='R'){
                    D.Rr=r; D.Rc=c;
                }else if(C=='B'){
                    D.Br=r; D.Bc=c;
                }
            }
        }
        return D;
    }
    public static void BFS(Data D){
        //test_print(D);
        if(D.Rr+D.Rc==0 && D.Br+D.Bc>0){    // 성공한 경우 (빨간 구슬은 나가고 파란 구슬은 나가지 않은 경우)
            System.out.println(D.cnt);
        }
        else if(D.cnt>10){ // 열 번 했는데 성공하지 못 한 경우
            System.out.println(-1);
        }
        else{
            if(!isDuplicated(D)){
                q.add(Move(new Data(D),0));
                q.add(Move(new Data(D),1));
                q.add(Move(new Data(D),2));
                q.add(Move(new Data(D),3));
            }
            Record.add(new RC(D));
            if(q.isEmpty()) System.out.println(-1); // 더 이상 경우의 수가 없는 경우
            else BFS(q.poll());
        }
    }
    static char[] d = {'U','D','L','R'};    // 상하좌우
    static int[] dr = {-1 , 1 , 0 , 0 };
    static int[] dc = { 0 , 0 ,-1 , 1 };
    public static Data Move(Data D, int I){
        if( (I==0 && D.Rr<D.Br) || (I==1 && D.Rr>D.Br) || (I==2 && D.Rc<D.Bc) || (I==3 && D.Rc>D.Bc)){
            MoveRed(D,I);
            MoveBlue(D,I);
        }
        else{
            MoveBlue(D,I);
            MoveRed(D,I);
        }
        D.p+=d[I];
        return D;
    }
    public static void MoveRed(Data D, int I){
        if(D.Rr+D.Rc!=0) while(true){
            char next = Map[D.Rr+dr[I]][D.Rc+dc[I]];
            if((next=='#') || (D.Rr+dr[I]==D.Br && D.Rc+dc[I]==D.Bc)){  // 벽 || 파란공
                break;
            }
            else if(next=='O'){ // 출구
                D.Rr=0;
                D.Rc=0;
                break;
            }
            else{   // 진행
                D.Rr+=dr[I];
                D.Rc+=dc[I];
            }
        }
    }
    public static void MoveBlue(Data D, int I){
        if(D.Br+D.Bc!=0) while(true){
            char next = Map[D.Br+dr[I]][D.Bc+dc[I]];
            if((next=='#') || (D.Rr==D.Br+dr[I] && D.Rc==D.Bc+dc[I])){  // 벽 || 빨간공
                break;
            }
            else if(next=='O'){ // 출구
                D.Br=0;
                D.Bc=0;
                break;
            }
            else{   // 진행
                D.Br+=dr[I];
                D.Bc+=dc[I];
            }
        }
    }
    public static boolean isDuplicated(Data D){
        for(int i=0; i<Record.size(); i++){
            if( D.Rr==Record.get(i).Rr && D.Rc==Record.get(i).Rc && D.Br==Record.get(i).Br && D.Bc==Record.get(i).Bc)
                return true;
        }
        return false;
    }
    public static void test_print(Data D){
        System.out.println(D.cnt+" "+D.p);
        for(int r=0; r<N; r++){
            for(int c=0; c<M; c++){
                if(D.Rr==r && D.Rc==c) System.out.print('R');
                else if(D.Br==r && D.Bc==c) System.out.print('B');
                else System.out.print(Map[r][c]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
