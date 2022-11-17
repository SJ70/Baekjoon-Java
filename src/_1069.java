import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1069 {
    static double X,Y,DISTANCE,JUMP_TIME,JUMP_DIST;
    static double ResultTime = 0f;
    public static void main(String[] args) throws IOException{
        init();

        // 점프의 효율 자체가 걸을 때보다 안 좋은 경우
        if(JUMP_DIST / JUMP_TIME <= 1f){
            System.out.println(DISTANCE);
            return;
        }

        // 일단 점프해서 갈 수 있는 만큼 이동
        ResultTime += (int)(DISTANCE/JUMP_DIST) * JUMP_TIME;
        DISTANCE %= JUMP_DIST;

        // 그냥 걸어가는 시간
        double walkTime = DISTANCE;
        double jumpTime = 0f;

        // 이전에 점프를 했을 경우 다음 점프는 사정거리 이내라면 어디든 갈 수 있음
        // 2번의 점프로 점프의 사정거리*2 이내의 거리 어디든 갈 수 있기 때문 (이등변삼각형)
        if(ResultTime>0f){
            jumpTime = JUMP_TIME;
        }
        // 점프를 하지 않았을 경우
        // 점프 후 지나온 거리를 돌아가는 것 vs 두 번 점프
        else{
            double jumpAndWalkTime = (JUMP_DIST-DISTANCE)+JUMP_TIME;
            double jumpAndJumpTime = JUMP_TIME*2;
            jumpTime = Math.min(jumpAndWalkTime, jumpAndJumpTime);
        }

        ResultTime += Math.min(jumpTime,walkTime);

        System.out.println(ResultTime);
    }
    public static void init() throws IOException{
        StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
        X = Double.parseDouble(st.nextToken());
        Y = Double.parseDouble(st.nextToken());
        DISTANCE = Math.sqrt(X*X + Y*Y);
        JUMP_DIST = Double.parseDouble(st.nextToken());
        JUMP_TIME = Double.parseDouble(st.nextToken());
    }
}
