import java.io.*;
import java.util.*;

public class _1012 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            Input();
            int block = 0;
            while(!Qr.isEmpty()){
                int r = Qr.poll();
                int c = Qc.poll();
                if(visited[r][c]) continue;
                //Print();
                visitNearby(r,c);
                block++;
            }
            System.out.println(block);
        }
    }
    static int R,C,K;
    static boolean[][] Map,visited;
    static Queue<Integer> Qr,Qc;
    public static void Input() throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        Qr = new ArrayDeque<>();
        Qc = new ArrayDeque<>();
        Map = new boolean[R][C];
        visited = new boolean[R][C];
        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            Map[r][c] = true;
            Qr.add(r);
            Qc.add(c);
        }
    }
    public static void visitNearby(int r, int c){
        if( r<0 || r>=R || c<0 || c>=C || visited[r][c] || !Map[r][c] ) return;
        visited[r][c] = true;
        visitNearby(r+1,c);
        visitNearby(r-1,c);
        visitNearby(r,c+1);
        visitNearby(r,c-1);
    }
    public static void Print(){
        System.out.println();
        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                System.out.print(visited[r][c]?'O':Map[r][c]?'x':'.');
            }
            System.out.println();
        }
    }
}
