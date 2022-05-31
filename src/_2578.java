import java.util.Scanner;

public class _2578 {
    static boolean[][] Map = new boolean[5][5];
    static int[] R = new int[26];
    static int[] C = new int[26];
    static Scanner sc = new Scanner(System.in);
    static int result;

    public static void main(String[] args){
        InputMap();
        PlayGame();
        System.out.println(result);
    }
    public static void InputMap(){
        for(int r=0; r<5; r++){
            for(int c=0; c<5; c++){
                int N = sc.nextInt();
                R[N] = r;
                C[N] = c;
            }
        }
    }
    public static void PlayGame(){
        for(result=1; result<=25; result++){
            int n = sc.nextInt();
            int r = R[n];
            int c = C[n];
            Map[r][c] = true;
            if(ThreeBingo()) break;
        }
    }
    public static boolean ThreeBingo(){
        int cnt = 0;
        for(int i=0; i<5; i++){ // 가로세로
            if( Map[0][i] && Map[1][i] && Map[2][i] && Map[3][i] && Map[4][i]) cnt++;
            if( Map[i][0] && Map[i][1] && Map[i][2] && Map[i][3] && Map[i][4]) cnt++;
        }
        if( Map[0][0] && Map[1][1] && Map[2][2] && Map[3][3] && Map[4][4]) cnt++; //우하향대각
        if( Map[0][4] && Map[1][3] && Map[2][2] && Map[3][1] && Map[4][0]) cnt++; //우하향대각
        return cnt >= 3;
    }
}