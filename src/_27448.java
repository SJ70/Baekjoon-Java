import java.io.*;
import java.util.*;

public class _27448 {
    public static void main(String[] args) throws IOException{
        init();
        System.out.println(getResult());
    }
    static int R,C,F;
    static boolean[][] Wood;
    public static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        F = Integer.parseInt(st.nextToken());
        Wood = new boolean[R][C];
        for(int r=0; r<R; r++){
            String str = br.readLine();
            for(int c=0; c<C; c++){
                Wood[r][c] = str.charAt(c)=='#';
            }
        }
    }
    public static int getResult(){
        int result = 0;

        for(int r=0; r<=R-2; r++){

            int left = 0;
            int cutCnt = 0;
            while(left<C && !(Wood[r][left] && Wood[r+1][left])){
                // 끝까지 가거나 자르지 말아야 할 부분까지
                if(Wood[r][left]!=Wood[r+1][left]){
                    // 반드시 잘라야 할 부분
                    cutCnt++;
                }
                left++;
            }
            result += Math.min(cutCnt, F);

            int right = C-1;
            cutCnt = 0;
            while(left<right && !(Wood[r][right] && Wood[r+1][right])){
                // 끝까지 가거나 자르지 말아야 할 부분까지
                if(Wood[r][right]!=Wood[r+1][right]){
                    // 반드시 잘라야 할 부분
                    cutCnt++;
                }
                right--;
            }
            result += Math.min(cutCnt, F);

            for(int i=left+1; i<right; i++){
                if(Wood[r][i]!=Wood[r+1][i]){
                    result++;
                }
            }
        }

        for(int c=0; c<=C-2; c++){

            int up = 0;
            int cutCnt = 0;
            while(up<R && !(Wood[up][c] && Wood[up][c+1])){
                // 끝까지 가거나 자르지 말아야 할 부분까지
                if(Wood[up][c]!=Wood[up][c+1]){
                    // 반드시 잘라야 할 부분
                    cutCnt++;
                }
                up++;
            }
            result += Math.min(cutCnt, F);

            int down = R-1;
            cutCnt = 0;
            while(up<down && !(Wood[down][c] && Wood[down][c+1])){
                // 끝까지 가거나 자르지 말아야 할 부분까지
                if(Wood[down][c]!=Wood[down][c+1]){
                    // 반드시 잘라야 할 부분
                    cutCnt++;
                }
                down--;
            }
            result += Math.min(cutCnt, F);

            for(int i=up+1; i<down; i++){
                if(Wood[i][c]!=Wood[i][c+1]){
                    result++;
                }
            }
        }

        return result;
    }
}
