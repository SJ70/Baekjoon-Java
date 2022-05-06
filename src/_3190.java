import java.util.*;
import java.io.*;

public class _3190 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] Map;
    static int N, K, L;    // 보드크기, 사과갯수, 방향전환횟수
    static int r, c;    // 뱀위치
    static Queue<Integer> Qr = new ArrayDeque<>();
    static Queue<Integer> Qc = new ArrayDeque<>();
    static int Dir;
    static int[] dr = { 0, 1, 0,-1};
    static int[] dc = { 1, 0,-1, 0};
    static char[] turn = new char[10001]; // 전환 정보 배열
    static int second = 0;  // 시간

    public static void Input() throws IOException{
        // 보드 크기
        N = Integer.parseInt(br.readLine());
        Map = new int[N][N];
        // 사과 위치
        K = Integer.parseInt(br.readLine());
        for(int i=0; i<K; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            Map[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = 2;
        }
        // 뱀 방향 변환
        L = Integer.parseInt(br.readLine());
        for(int i=0; i<L; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);
            turn[n] = c;
        }
        // 뱀 초깃값
        Map[0][0]=1;
        Qr.add(0);
        Qc.add(0);
        r=0;c=0;Dir=0;
    }
    public static boolean OutofMap(){
        return ( r<0 || r>=N || c<0 || c>=N);
    }
    public static boolean AppleHere(){
        return Map[r][c] == 2;
    }
    public static boolean BodyHere(){
        return Map[r][c] == 1;
    }
    public static void TurnBody(char c){
        if(c=='D'){
            Dir++;
            if(Dir>3) Dir=0;
        }
        else if(c=='L'){
            Dir--;
            if(Dir<0) Dir=3;
        }
    }
    public static void test_print(){
        System.out.printf("\n#%d: Dir:%d \n",second,Dir);
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++){
                System.out.print(Map[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) throws IOException{
        Input();
        while(true){
            //test_print();
            second++;
            r+=dr[Dir];
            c+=dc[Dir];
            Qr.add(r);
            Qc.add(c);
            if(OutofMap() || BodyHere()) break;   // 맵 밖으로 나가거나 본인 몸에 부딪힌 경우
            else{
                if(!AppleHere()){    // 사과가 없는 경우
                    Map[Qr.poll()][Qc.poll()] = 0;
                }
                Map[r][c] = 1;
            }
            TurnBody(turn[second]);
        }
        System.out.println(second);
    }
}
