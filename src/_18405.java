import java.io.*;
import java.util.*;

public class _18405 {
    public static void main(String[] args) throws IOException{
        Input();
        for(int i=2; i<S+2; i++){
            Infect(i);
            //Print();
        }
        System.out.println(Map[X-1][Y-1]);
    }
    static int N,K, S,X,Y;
    static int[][] Map;
    static int[][] InfectedTime;
    static Queue<Integer> Qr = new ArrayDeque<>();
    static Queue<Integer> Qc = new ArrayDeque<>();
    public static void Input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        Map = new int[N][N];
        InfectedTime = new int[N][N];
        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                int N = Integer.parseInt(st.nextToken());
                if(N!=0){
                    Map[r][c]=N;
                    InfectedTime[r][c]=1;
                    Qr.add(r);
                    Qc.add(c);
                }
            }
        }
        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
    }
    public static void Print(){
        for(int r=0; r<N; r++){
            System.out.println();
            for(int c=0; c<N; c++){
                System.out.printf("%3d",Map[r][c]);
                //System.out.printf(",%d",InfectedTime[r][c]);
            }
        }
        System.out.println();
    }
    public static void Infect(int time){
        int size = Qr.size();
        for(int i=0; i<size; i++){
            int r = Qr.poll();
            int c = Qc.poll();
            int Virus = Map[r][c];
            InfectNearby(r+1,c,Virus,time);
            InfectNearby(r-1,c,Virus,time);
            InfectNearby(r,c+1,Virus,time);
            InfectNearby(r,c-1,Virus,time);
        }
    }
    public static void InfectNearby(int r, int c, int Virus, int time){
        if( r==-1 || r==N || c==-1 || c==N ) return;
        // 비어있는 경우 감염 || 감염된 시간이 같을 때, 우선순위 비교
        if((Map[r][c]==0) || (InfectedTime[r][c]==time && Map[r][c]>Virus)){
            Map[r][c]=Virus;
            InfectedTime[r][c]=time;
            Qr.add(r);
            Qc.add(c);
        }
    }
}
