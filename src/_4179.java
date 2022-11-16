import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
//불도 벽으로 생각
public class _4179 {
    static int R,C;
    static int[][] M;
    static Queue<Integer> PersonQ = new ArrayDeque<>();
    static Queue<Integer> FireQ = new ArrayDeque<>();
    static final int VISITABLE = 0; //empty
    static final int WALL = -1;
    static int ResultTime = -1;
    public static void main(String[] args) throws IOException{
        init();
//        printM();

        while(!PersonQ.isEmpty()){
            int repeat = FireQ.size();
            for(int i=0; i<repeat; i+=2)
                spreadFire(FireQ.poll(),FireQ.poll());

            repeat = PersonQ.size();
            for(int i=0; i<repeat && !PersonQ.isEmpty(); i+=3)
                visitNearby(PersonQ.poll(),PersonQ.poll(),PersonQ.poll());

//            printM();
        }

        System.out.println( (ResultTime==-1) ? "IMPOSSIBLE" : ResultTime );
    }
    public static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = new int[R][C];
        for(int r=0; r<R; r++){
            String str = br.readLine();
            for(int c=0; c<C; c++){
                switch(str.charAt(c)){
                    case'.': break;
                    case'#': M[r][c] = WALL; break;
                    case'F': setFire(r,c); break;
                    case'J': visit(r,c,1); break;
                }
            }
        }
    }
    public static void visit(int r, int c, int time){
        M[r][c] = time;
        PersonQ.add(r);
        PersonQ.add(c);
        PersonQ.add(time);
    }
    public static void visitNearby(int r, int c, int time){
        if(r-1<0 || r+1==R || c-1<0 || c+1==C){
            PersonQ.clear();
            ResultTime = time;
            return;
        }
        if(M[r-1][c]==VISITABLE) visit(r-1,c,time+1);
        if(M[r+1][c]==VISITABLE) visit(r+1,c,time+1);
        if(M[r][c-1]==VISITABLE) visit(r,c-1,time+1);
        if(M[r][c+1]==VISITABLE) visit(r,c+1,time+1);
    }
    public static void setFire(int r, int c){
        M[r][c] = WALL;
        FireQ.add(r);
        FireQ.add(c);
    }
    public static void spreadFire(int r, int c){
        if(r-1>=0 && M[r-1][c]!=WALL) setFire(r-1,c);
        if(r+1<R  && M[r+1][c]!=WALL) setFire(r+1,c);
        if(c-1>=0 && M[r][c-1]!=WALL) setFire(r,c-1);
        if(c+1<C  && M[r][c+1]!=WALL) setFire(r,c+1);
    }
    public static void printM(){
        System.out.println();
        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                if(M[r][c]==WALL) System.out.print(" #");
                else if(M[r][c]==VISITABLE) System.out.print(" .");
                else System.out.printf("%2d",M[r][c]);
            }
            System.out.println();
        }
    }
}
