import java.io.*;
import java.util.*;

public class _5427 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            init();
            sb.append(getResult()).append('\n');
        }
        System.out.print(sb);
    }
    static final char FIRE = '*';
    static final char PERSON = '@';
    static final char VISITED = '@';
    static final char WALL = '#';
    static Queue<int[]> personQ = new ArrayDeque<>();
    static Queue<int[]> fireQ = new ArrayDeque<>();
    static int R,C;
    static char[][] Arr;
    public static void init() throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Arr = new char[R][C];
        personQ.clear();
        fireQ.clear();
        for(int r=0; r<R; r++){
            String str = br.readLine();
            for(int c=0; c<C; c++){
                Arr[r][c] = str.charAt(c);
                if(Arr[r][c]==PERSON){
                    personQ.add(new int[]{r,c});
                }
                else if(Arr[r][c]==FIRE){
                    fireQ.add(new int[]{r,c});
                }
            }
        }
    }
    public static String getResult(){
        int time = 0;
        while(!personQ.isEmpty()){
            time++;
            int repeat = fireQ.size();
            for(int i=0; i<repeat && !fireQ.isEmpty(); i++){
                int r = fireQ.peek()[0];
                int c = fireQ.poll()[1];
                setFire(r-1,c);
                setFire(r+1,c);
                setFire(r,c-1);
                setFire(r,c+1);
            }
            repeat = personQ.size();
            for(int i=0; i<repeat && !personQ.isEmpty(); i++){
                int r = personQ.peek()[0];
                int c = personQ.poll()[1];
                try{
                    visit(r-1,c);
                    visit(r+1,c);
                    visit(r,c-1);
                    visit(r,c+1);
                }
                catch(Exception e){
                    return String.valueOf(time);
                }
            }
        }
        return "IMPOSSIBLE";
    }
    public static void setFire(int r, int c){
        if(r<0 || r>=R || c<0 || c>=C || Arr[r][c]==FIRE || Arr[r][c]==WALL) return;
        Arr[r][c] = FIRE;
        fireQ.add(new int[]{r,c});
    }
    public static void visit(int r, int c) throws Exception{
        if(r<0 || r>=R || c<0 || c>=C) throw new Exception();
        if(Arr[r][c]==WALL || Arr[r][c]==FIRE || Arr[r][c]==VISITED) return;
        Arr[r][c] = VISITED;
        personQ.add(new int[]{r,c});
    }
}
