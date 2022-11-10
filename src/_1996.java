import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class _1996 {
    static int N;
    static int[][] Map;
    public static void main(String[] args) throws IOException{
        init();
        while(!Q.isEmpty()) setMine(Q.poll());
        printMap();
    }
    static Queue<int[]> Q = new ArrayDeque<>();
    static final int VALUE = 0;
    static final int ROW = 1;
    static final int COLUMN = 2;
    public static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int r=0; r<N; r++){
            String str = br.readLine();
            for(int c=0; c<N; c++){
                if(str.charAt(c)!='.'){
                    int[] mine = new int[3];
                    mine[VALUE] = str.charAt(c)-'0';
                    mine[ROW] = r;
                    mine[COLUMN] = c;
                    Q.add(mine);
                }
            }
        }
        Map = new int[N][N];
    }
    public static void setMine(int[] mine){
        for(int r=mine[ROW]-1; r<=mine[ROW]+1; r++){
            if(r<0 || r>=N) continue;
            for(int c=mine[COLUMN]-1; c<=mine[COLUMN]+1; c++){
                if(c<0 || c>=N) continue;
                Map[r][c] += mine[VALUE];
            }
        }
        Map[mine[ROW]][mine[COLUMN]] = -100;
    }
    public static void printMap(){
        StringBuilder sb = new StringBuilder();
        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                if(Map[r][c]<0) sb.append('*');
                else if(Map[r][c]>=10) sb.append('M');
                else sb.append(Map[r][c]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
