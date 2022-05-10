import java.io.*;
import java.util.*;

public class _12100 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int Max = 0;
    public static class Map{
        int[][] map = new int[N][N];
        boolean changed = true;
        int cnt;
        public Map(int n){
            this.cnt = n;
        }
    }

    public static void main(String[] args) throws IOException{
        Map M = Input();
        //test_print(M);
        BF(M);
        System.out.println(Max);
//        test_print(MoveLeft(M));
//        test_print(MoveRight(M));
//        test_print(MoveUp(M));
//        test_print(MoveDown(M));
    }
    public static Map Input() throws IOException{
        N = Integer.parseInt(br.readLine());
        Map M = new Map(0);
        for(int r=0; r<N; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                int tmp = Integer.parseInt(st.nextToken());
                Max = Math.max( tmp, Max );
                M.map[r][c] = tmp;
            }
        }
        return M;
    }
    public static void test_print(Map M){
        for(int r=0; r<N; r++) {
            System.out.println();
            for(int c=0; c<N; c++)
                System.out.printf(" %4d",M.map[r][c]);;
        }
        System.out.println(" cnt:"+M.cnt);
    }
    public static void BF(Map M){
        //test_print(M);
        if(M.cnt<5 && M.changed){
            BF(MoveLeft(M));
            BF(MoveRight(M));
            BF(MoveUp(M));
            BF(MoveDown(M));
        }
    }
    static Queue<Integer> q1 = new ArrayDeque<>();
    static Queue<Integer> q2 = new ArrayDeque<>();
    public static boolean isSame (Map M1, Map M2){
        for(int r=0; r<N; r++)
            for(int c=0; c<N; c++)
                if(M1.map[r][c]!=M2.map[r][c]) return false;
        return true;
    }
    public static Map MoveLeft(Map M) {
        Map M2 = new Map(M.cnt+1);
        for(int r=0; r<N; r++) {
            for(int c=0; c<N; c++)
                if(M.map[r][c]!=0)
                    q1.add(M.map[r][c]);
            while(!q1.isEmpty()){
                int tmp = q1.poll();
                if(!q1.isEmpty() && tmp == q1.peek()){
                    q2.add( q1.poll()*2 );
                }
                else q2.add(tmp);
            }
            int tmp = 0;
            while(!q2.isEmpty()){
                Max = Math.max( q2.peek(), Max );
                M2.map[r][tmp++] = q2.poll();
            }
        }
        M2.changed = (!isSame(M,M2));
        return M2;
    }
    public static Map MoveRight(Map M) {
        Map M2 = new Map(M.cnt+1);
        for(int r=0; r<N; r++) {
            for(int c=N-1; c>=0; c--)
                if(M.map[r][c]!=0)
                    q1.add(M.map[r][c]);
            while(!q1.isEmpty()){
                int tmp = q1.poll();
                if(!q1.isEmpty() && tmp == q1.peek()){
                    q2.add( q1.poll()*2 );
                }
                else q2.add(tmp);
            }
            int tmp = N-1;
            while(!q2.isEmpty()){
                Max = Math.max( q2.peek(), Max );
                M2.map[r][tmp--] = q2.poll();
            }
        }
        M2.changed = (!isSame(M,M2));
        return M2;
    }
    public static Map MoveUp(Map M) {
        Map M2 = new Map(M.cnt+1);
        for(int c=0; c<N; c++) {
            for(int r=0; r<N; r++)
                if(M.map[r][c]!=0)
                    q1.add(M.map[r][c]);
            while(!q1.isEmpty()){
                int tmp = q1.poll();
                if(!q1.isEmpty() && tmp == q1.peek()){
                    q2.add( q1.poll()*2 );
                }
                else q2.add(tmp);
            }
            int tmp = 0;
            while(!q2.isEmpty()) {
                Max = Math.max( q2.peek(), Max );
                M2.map[tmp++][c] = q2.poll();
            }
        }
        M2.changed = (!isSame(M,M2));
        return M2;
    }
    public static Map MoveDown(Map M) {
        Map M2 = new Map(M.cnt+1);
        for(int c=0; c<N; c++) {
            Queue<Integer> q1 = new ArrayDeque<>();
            Queue<Integer> q2 = new ArrayDeque<>();
            for(int r=N-1; r>=0; r--)
                if(M.map[r][c]!=0)
                    q1.add(M.map[r][c]);
            while(!q1.isEmpty()){
                int tmp = q1.poll();
                if(!q1.isEmpty() && tmp == q1.peek()){
                    q2.add( q1.poll()*2 );
                }
                else q2.add(tmp);
            }
            int tmp = N-1;
            while(!q2.isEmpty()) {
                Max = Math.max( q2.peek(), Max );
                M2.map[tmp--][c] = q2.poll();
            }
        }
        M2.changed = (!isSame(M,M2));
        return M2;
    }
}