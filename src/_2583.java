import java.io.*;
import java.util.*;

public class _2583 {
    static int R,C;
    static boolean[][] Map;
    static PriorityQueue<Integer> result = new PriorityQueue<>();
    public static void main(String[] args) throws IOException{
        init();
        solve();
        print();
    }
    public static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Map = new boolean[R][C];
        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int c_from = Integer.parseInt(st.nextToken());
            int r_from = Integer.parseInt(st.nextToken());
            int c_to = Integer.parseInt(st.nextToken());
            int r_to = Integer.parseInt(st.nextToken());
            for(int r=r_from; r<r_to; r++){
                for(int c=c_from; c<c_to; c++){
                    Map[r][c] = true;
                }
            }
        }
    }
    public static void solve(){
        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                if(!Map[r][c]){
                    result.add(getSectionSize(r,c));
                }
            }
        }
    }
    public static int getSectionSize(int r, int c){
        Map[r][c]=true;
        int size = 1;
        if(r-1>=0 && !Map[r-1][c]) size += getSectionSize(r-1,c);
        if(r+1<R && !Map[r+1][c]) size += getSectionSize(r+1,c);
        if(c-1>=0 && !Map[r][c-1]) size += getSectionSize(r,c-1);
        if(c+1<C && !Map[r][c+1]) size += getSectionSize(r,c+1);
        return size;
    }
    public static void print(){
        StringBuilder sb = new StringBuilder();
        sb.append(result.size()).append('\n');
        while(!result.isEmpty()){
            sb.append(result.poll()).append(' ');
        }
        System.out.println(sb);
    }
}
