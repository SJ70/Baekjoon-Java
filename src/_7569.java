import java.io.*;
import java.util.*;

public class _7569 {
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
    static int R,C,H, Remain;
    static int[][][] Map;
    static Queue<Integer> Qh = new ArrayDeque<>();
    static Queue<Integer> Qr = new ArrayDeque<>();
    static Queue<Integer> Qc = new ArrayDeque<>();
    public static void Input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        Map = new int[H][R][C];
        for(int h=0; h<H; h++){
            for(int r=0; r<R; r++){
                st = new StringTokenizer(br.readLine());
                for(int c=0; c<C; c++){
                    Map[h][r][c] = Integer.parseInt(st.nextToken());
                    if(Map[h][r][c]==1){
                        Qh.add(h);
                        Qr.add(r);
                        Qc.add(c);
                    }
                    else if(Map[h][r][c]==0){
                        Remain++;
                    }
                }
            }
        }
    }
    public static void Ripe(){
        int T = Qr.size();
        for(int i=0; i<T; i++){
            int h = Qh.poll();
            int r = Qr.poll();
            int c = Qc.poll();
            RipeNearby(h+1,r,c);
            RipeNearby(h-1,r,c);
            RipeNearby(h,r+1,c);
            RipeNearby(h,r-1,c);
            RipeNearby(h,r,c+1);
            RipeNearby(h,r,c-1);
        }
    }
    public static void RipeNearby(int h, int r, int c){
        if( h<0 || h>=H || r<0 || r>=R || c<0 || c>=C ) return;
        if( Map[h][r][c]==0 ){
            Qh.add(h);
            Qr.add(r);
            Qc.add(c);
            Map[h][r][c]=1;
            Remain--;
        }
    }
    public static void Print(){
        for(int h=0; h<H; h++){
            for(int r=0; r<R; r++){
                System.out.println();
                for(int c=0; c<C; c++){
                    System.out.printf("%2d",Map[h][r][c]);
                }
            }
        }
        System.out.println();
    }
}
