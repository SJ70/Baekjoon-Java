import java.io.*;
import java.util.*;

public class _1926 {
    public static void main(String[] args) throws IOException{
        init();
        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                if(Map[r][c] && !Visited[r][c]){
                    index++;
                    visit(r,c);
                    Max_size = Math.max(Max_size ,size);
                    size=0;
                }
            }
        }
        System.out.printf("%d\n%d",index,Max_size);
    }

    static int R,C;
    static boolean[][] Map, Visited;
    public static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        Map = new boolean[R][C];
        Visited = new boolean[R][C];
        for(int r=0; r<R; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<C; c++){
                Map[r][c] = st.nextToken().equals("1");
            }
        }
    }

    static int index = 0;
    static int Max_size = 0;
    static int size = 0;
    public static void visit(int r, int c){
        size++;
        Visited[r][c]=true;
        if(r+1<R && Map[r+1][c] && !Visited[r+1][c]) visit(r+1,c);
        if(r-1>=0 && Map[r-1][c] && !Visited[r-1][c]) visit(r-1,c);
        if(c+1<C && Map[r][c+1] && !Visited[r][c+1]) visit(r,c+1);
        if(c-1>=0 && Map[r][c-1] && !Visited[r][c-1]) visit(r,c-1);
    }
}
