import java.util.*;
        import java.io.*;

public class _14499 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int[][] map;
    static int[] command;
    static int[] dice = new int[6];  // 0:밑면, 1:동쪽, 2:서쪽, 3:북쪽, 4:남쪽, 5:윗면
    static int N, M, x, y, K;

    public static void Input() throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        command = new int[K];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<K; i++){
            command[i] = Integer.parseInt(st.nextToken());
        }
    }
    public static void ChangeDiceValue(int a, int b, int c, int d){
        // a <- b <- c <- d <- a
        int tmp = dice[a];
        dice[a] = dice[b];
        dice[b] = dice[c];
        dice[c] = dice[d];
        dice[d] = tmp;
    }
    public static void CopyValue() throws IOException{
        if(map[x][y]==0) map[x][y] = dice[0];
        else {
            dice[0] = map[x][y];
            map[x][y] = 0;
        }
        bw.write((dice[5])+"\n");
    }
    public static void Roll(int n) throws IOException{
        // 0:밑면, 1:동쪽, 2:서쪽, 3:북쪽, 4:남쪽, 5:윗면
        switch(n){  // 좌표 밖 확인
            case 1:{
                if(y+1 <= M-1){
                    y++;
                    ChangeDiceValue(0,1,5,2);
                    CopyValue();
                }
                break;
            }
            case 2:{
                if(y-1 >= 0){
                    y--;
                    ChangeDiceValue(0,2,5,1);
                    CopyValue();
                }
                break;
            }
            case 3:{
                if(x-1 >= 0){
                    x--;
                    ChangeDiceValue(0,3,5,4);
                    CopyValue();
                }
                break;
            }
            case 4:{
                if(x+1 <= N-1){
                    x++;
                    ChangeDiceValue(0,4,5,3);
                    CopyValue();
                }
                break;
            }
            default: break;
        }
    }
    public static void main(String[] args) throws IOException{
        Input();
        for(int i=0; i<K; i++){
            Roll(command[i]);
        }
        bw.flush();
    }
}
