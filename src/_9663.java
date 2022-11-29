import java.util.*;

public class _9663 {
    static int N;
    static boolean[][] Map;
    static int Able = 0;
    public static void main(String[] args){
        N = new Scanner(System.in).nextInt();
        Map = new boolean[N][N];
        BT(0,0,0);
        System.out.println(Able);
    }
    public static void test_print(){
        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                System.out.print(Map[r][c]?"  Q":"  .");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void BT(int r, int c, int cnt){
        if(r<N){
            //System.out.println(r+" "+c);
            if(isAble(r,c)){   // 놓을 수 있다면
                Map[r][c] = true;   // 놓고 다음 줄로 (한 줄 당 놓을 수 있는 퀸은 1개)
                test_print();
                if(cnt+1==N){ // N개 다 놓은 경우
                    //test_print();
                    Able++;
                }
                else BT(r+1,0,cnt+1);
                Map[r][c] = false;
            }
            if(c+1<N) BT(r,c+1,cnt);    // 놓지 않고 다음 칸으로
            //else BF(r+1,0,cnt);   // 놓지 않고 다음 줄로 넘어가는 경우는 답이 없음
        }
    }
    public static boolean isAble(int r, int c){
        // 현재 놓은 말의 가능성 여부만 판단하면 됨
        // (0,0)에서부터 우하단으로 채워나가므로 필요한 범위만 판단
        // 말을 놓으면 다음 줄로 넘어가기에 좌측은 판단할 필요 없음
        for(int i=0; i<r; i++){ // 상단
            if( Map[i][c] ) return false;
        }
        for(int i=0; r-i>=0 && c-i>=0 ; i++){ // 좌상향대각
            if( Map[r-i][c-i] ) return false;
        }
        for(int i=0; r-i>=0 && c+i<N; i++){ // 우상향대각
            if( Map[r-i][c+i] ) return false;
        }
        return true;
    }
}
