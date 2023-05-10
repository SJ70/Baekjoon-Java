import java.io.*;
import java.util.*;

public class _9328 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int R, C, DocCnt;
    static char[][] Map;
    static boolean[] Unlocked;
    static Queue<int[]> lockedDoor;
    static boolean MapChanged;
    public static void main(String[] args) throws IOException{
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            init();
            visitBorder();

            while(!lockedDoor.isEmpty()){
                // 열 수 없는 문을 계속 방문하는 것을 방지하기 위해 루프마다 변화를 감시
                int loop = lockedDoor.size();
                MapChanged = false;
                for(int i=0; i<loop; i++){
                    int r = lockedDoor.peek()[0];
                    int c = lockedDoor.poll()[1];
                    visit(r,c);
                }
                if(!MapChanged) break;
            }

            sb.append(DocCnt).append('\n');
        }
        System.out.print(sb);
    }
    public static void init() throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        DocCnt = 0;
        Map = new char[R][C];
        for(int r=0; r<R; r++){
            String str = br.readLine();
            for(int c=0; c<C; c++){
                Map[r][c] = str.charAt(c);
            }
        }
        Unlocked = new boolean[26];
        String Keys = br.readLine();
        if(Keys.charAt(0)!='0'){
            for(int i=0; i<Keys.length(); i++){
                Unlocked[Keys.charAt(i)-'a'] = true;
            }
        }
        lockedDoor = new ArrayDeque<>();
    }
    public static void visitBorder(){
        for(int c=0; c<C; c++){
            visit(0,c);
            visit(R-1,c);
        }
        for(int r=1; r<R-1; r++){
            visit(r,0);
            visit(r,C-1);
        }
    }
    public static void setVisited(int r, int c){
        // 한 번 방문한 지역을 벽으로 만들어 중복 방문 배제
        Map[r][c]='*';
    }
    public static boolean isWall(char c){
        return c=='*';
    }
    public static boolean isDoc(char c){
        return c=='$';
    }
    public static boolean isKey(char c){
        return c>='a' && c<='z';
    }
    public static void takeKey(char c){
        Unlocked[c-'a'] = true;
    }
    public static boolean isDoor(char c){
        return c>='A' && c<='Z';
    }
    public static boolean hasKey(char c){
        return Unlocked[c-'A'];
    }
    public static void visit(int r, int c){ //dfs
        if(r<0 || r>=R || c<0 || c>=C) return;

        char here = Map[r][c];
        if(isWall(here)) return;

        if(isDoor(here) && !hasKey(here)){
            lockedDoor.add(new int[]{r,c});
        }
        else{
            if(isKey(here)) takeKey(here);
            else if(isDoc(here)) DocCnt++;
            setVisited(r,c);
            visitNearby(r,c);
            MapChanged = true; // line 19
        }
    }
    public static void visitNearby(int r, int c){
        visit(r+1,c);
        visit(r-1,c);
        visit(r,c-1);
        visit(r,c+1);
    }
}
