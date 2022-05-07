import java.util.*;
import java.io.*;

public class _14719 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int H;
    static int W;
    static int[][] Map;
    static int Amount = 0;

    public static void Input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        Map = new int[H][W];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<W; i++){
            int height = Integer.parseInt(st.nextToken());
            for(int j=H-height; j<H; j++){
                Map[j][i] = 1; //wall
            }
        }
    }
    public static void StackRain(int height){
        int cntTmp = 0; // 빗물 값 임시 저장
        boolean isCounting = false; // 공간을 세는 상태
        // 첫번째 공간에는 빈 공간이 있으면 어차피 카운팅이 안 되므로 인덱스1부터 연산
        for(int i=1; i<W; i++){
            if(Map[height][i]==0){  // 현재 빈 공간이면
                if(Map[height][i-1]==1){
                    isCounting=true;  // 이전에 벽이 있었다면 세고 있는 상태
                    cntTmp=0;   // 세기 시작하면 초기화
                }
                if(isCounting) cntTmp++;    // 세고 있다면 cnt++
            }
            else{                   // 현재 벽이라면
                if(Map[height][i-1]==0){
                    isCounting=false;  // 이전에 빈 공간이 있었다면 세지 않는 상태
                    Amount += cntTmp;   // 세지 않는 상태가 되면 값을 더함
                }
            }
        }
    }
    public static void test_print(){
        for(int i=0; i<H; i++){
            for(int j=0; j<W; j++){
                System.out.print(Map[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) throws IOException {
        Input();
        //test_print();
        for(int i=H-1; i>=0; i--){
            StackRain(i);
        }
        System.out.println(Amount);
    }
}