import java.io.*;
import java.util.*;

public class _17232 {
    public static void main(String[] args) throws IOException {
        Input();
        //test_print();
        for(int i=0; i<T; i++){
            for(int r=0; r<N; r++){
                for(int c=0; c<M; c++){
                    Observe(r,c);
                }
            }
            Apply();
//            test_print();
//            System.out.println();
        }
        test_print();
    }
    static int N,M,T,K,a,b;
    static char[][] Map;
    public static void Input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        Map = new char[N][M];
        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        for(int r=0; r<N; r++){
            String str = br.readLine();
            for(int c=0; c<M; c++){
                Map[r][c] = str.charAt(c);
            }
        }
    }
    public static boolean hasLife(int r, int c){
        //System.out.println(r+" "+c+" "+(( r>=0 && r<N && c>=0 && c<M && Map[r][c]=='*')?"true":"false"));
        return ( r>=0 && r<N && c>=0 && c<M && Map[r][c]=='*');
    }
    public static int cntNearbyLives(int r, int c){
        int cnt = 0;
        int r1 = Math.max(0, r-K);
        int r2 = Math.min(N-1, r+K);
        int c1 = Math.max(0, c-K);
        int c2 = Math.min(M-1, c+K);
        for(int i=r1; i<=r2; i++)
            for(int j=c1; j<=c2; j++)
                if( i!=r || j!=c ){ // 주변만 세므로 제자리는 제외
                    cnt += hasLife(i,j) ? 1 : 0 ;
                    if(cnt>b) return cnt; // b를 초과할 경우 더 셀 필요 x
                }
//        System.out.printf("%2d ,%2d (%2d,%2d ~%2d,%2d ) : %d\n",r,c,r-K,c-K,r+K,c+K,cnt);
        return cnt;
    }
    public static void Observe(int r, int c){
        int Nearby = cntNearbyLives(r,c);
        // 1.생존 : 만약 현재 칸에 생명이 있고, 주위에 a개 이상 b개 이하의 생명이 있다면 현재 칸의 생명은 다음 단계에 살아남는다.
        // 2.고독 : 만약 현재 칸에 생명이 있고, 주위에 a개 미만의 생명이 있다면 현재 칸의 생명은 외로워서 죽는다.
        // 3.과밀 : 만약 현재 칸에 생명이 있고, 주위에 b개 초과의 생명이 있다면 현재 칸의 생명은 과밀로 죽는다.
        if( hasLife(r,c) && ( Nearby<a || Nearby>b ) ){
            qr.add(r);
            qc.add(c);
            ql.add(".");
        }
        // 4.탄생 : 만약 현재 칸에 생명이 없고, 주위에 a개 초과 b개 이하의 생명이 있다면 다음 단계에서 현재 칸에 생명이 생긴다.
        else if( !hasLife(r,c) && ( Nearby>a && Nearby<=b ) ){
            qr.add(r);
            qc.add(c);
            ql.add("*");
        }
    }
    public static void Apply(){
        while(!qr.isEmpty())
            Map[qr.poll()][qc.poll()] = ql.poll().charAt(0);
    }
    public static Queue<Integer> qr = new ArrayDeque<>();   // r값을 저장하는 큐
    public static Queue<Integer> qc = new ArrayDeque<>();   // c값을 저장하는 큐
    public static Queue<String> ql = new ArrayDeque<>();   // Map[r][c]값을 저장하는 큐
    public static void test_print(){
        //System.out.println();
        for(int r=0; r<N; r++){
            for(int c=0; c<M; c++){
                System.out.print(Map[r][c]);
            }
            System.out.println();
        }
    }
}
//53%시간초과