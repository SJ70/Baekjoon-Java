import java.util.Scanner;

public class _1018 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();   // 행|
        int N = sc.nextInt();   // 열-
        char[][] board = new char[M][N];            // 입력배열
        char[][][] board_ex = new char[2][8][8];    // 예시배열
        for(int i=0; i<M; i++) {// 배열채우기
            String scan = sc.next();
            for (int j=0; j<N; j++)
                board[i][j] = scan.charAt(j);
        }
        for(int i=0; i<8; i++){ // 예시배열
            for(int j=0; j<8; j++) {
                if ((i+j)%2==0) {
                    board_ex[0][i][j] = 'B';
                    board_ex[1][i][j] = 'W';
                } else {
                    board_ex[0][i][j] = 'W';
                    board_ex[1][i][j] = 'B';
                }
            }
        }

        int dif = 99;
        for(int k=0; k<=M-8; k++) {    // 8*8 비교
            for(int l=0; l<=N-8; l++) {
                int[] dif_tmp = {0,0};    // 차이값 초기화
                for(int i=0; i<8; i++) {
                    for (int j=0; j<8; j++) {
                        if(board[i+k][j+l]!=board_ex[0][i][j]) dif_tmp[0]++;
                        if(board[i+k][j+l]!=board_ex[1][i][j]) dif_tmp[1]++;
                    }
                }
                dif = Math.min(dif,Math.min(dif_tmp[0],dif_tmp[1]));    // 최솟값 부여
            }
        }
        System.out.println(dif);
    }
}
