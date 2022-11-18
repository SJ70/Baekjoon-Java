import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class _5577 {
    static int BallCnt;
    static ArrayList<Integer> Balls;
    static int MaxPopCnt = 0;
    public static void main(String[] args) throws IOException{
        init();
//        for(int Element : Balls) System.out.printf("%d ",Element);

        for(int i=1; i<=Balls.size()-2; i++){

            // 1개: 본인을 바꿔보고 시뮬레이트
            if(CountOf(i)==1){
                int PopCnt = 1 + SameColorCountOf(i-1,i+1);
                if(PopCnt>=4) MaxPopCnt = Math.max(MaxPopCnt, PopCnt + simulatePop(i-2,i+2));
            }

            // 3개: 양 쪽 공을 하나씩 바꿔보고 시뮬레이트
            if(CountOf(i)==3){
                // 왼쪽을 바꿔보기
                Balls.set(i-1, Balls.get(i-1)-1 );
                MaxPopCnt = Math.max(MaxPopCnt, 4 + simulatePop(i-1,i+1));
                Balls.set(i-1, Balls.get(i-1)+1 );
                // 오른쪽을 바꿔보기
                Balls.set(i+1, Balls.get(i+1)-1 );
                MaxPopCnt = Math.max(MaxPopCnt, 4 + simulatePop(i-1,i+1));
                Balls.set(i+1, Balls.get(i+1)+1 );
            }

        }
        System.out.println( BallCnt-MaxPopCnt );
    }
    public static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BallCnt = Integer.parseInt(br.readLine());
        Balls = new ArrayList<>();
        Balls.add(Integer.parseInt(br.readLine())*10+1);
        for(int i=1; i<BallCnt; i++){
            int color = Integer.parseInt(br.readLine());
            int lastBallIndex = Balls.size()-1;
            if( color == ColorOf(lastBallIndex) )
                Balls.set( lastBallIndex, Balls.get(lastBallIndex)+1 );
            else
                Balls.add( color*10+1 );
        }
    }
    public static int simulatePop(int left, int right){
        int TotalPopCnt = 0;
        while(true){
            int PopCnt = SameColorCountOf(left,right);
            if(PopCnt<4) break;
            TotalPopCnt += PopCnt;
            left--;
            right++;
        }
        return TotalPopCnt;
    }
    public static int SameColorCountOf(int left, int right){
        if(left<0 || right>=Balls.size()) return 0;
        if(ColorOf(left)==ColorOf(right)) return CountOf(left)+CountOf(right);
        return 0;
    }
    public static int ColorOf(int index){
        return Balls.get(index)/10;
    }
    public static int CountOf(int index){
        return Balls.get(index)%10;
    }
}
