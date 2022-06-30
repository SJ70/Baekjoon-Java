import java.io.*;
import java.util.*;

public class _7576 {
    static int day=0;
    static int recent_remain;
    public static void main(String[] args) throws IOException{
        Input();
        while (true) {
            if(Remain==0) break;
            recent_remain=Remain;
            Ripe();
            day++;
            //Print();
            if(recent_remain==Remain){
                day = -1;
                break;
            }
        }
        System.out.println(day);
    }
    static int R,C, Remain;
    static int[][] Map;
    static Queue<Integer> Qr = new ArrayDeque<>();
    static Queue<Integer> Qc = new ArrayDeque<>();
    public static void Input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Map = new int[R][C];
        for(int r=0; r<R; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<C; c++){
                Map[r][c] = Integer.parseInt(st.nextToken());
                if(Map[r][c]==1){
                    Qr.add(r);
                    Qc.add(c);
                }
                else if(Map[r][c]==0){
                    Remain++;
                }
            }
        }
    }
    public static void Ripe(){
        int T = Qr.size();
        for(int i=0; i<T; i++){
            int r = Qr.poll();
            int c = Qc.poll();
            RipeNearby(r+1,c);
            RipeNearby(r-1,c);
            RipeNearby(r,c+1);
            RipeNearby(r,c-1);
        }
    }
    public static void RipeNearby(int r, int c){
        if( r<0 || r>=R || c<0 || c>=C ) return;
        if( Map[r][c]==0 ){
            Qr.add(r);
            Qc.add(c);
            Map[r][c]=1;
            Remain--;
        }
    }
    public static void Print(){
        for(int r=0; r<R; r++){
            System.out.println();
            for(int c=0; c<C; c++){
                System.out.printf("%2d",Map[r][c]);
            }
        }
        System.out.println();
    }
}
