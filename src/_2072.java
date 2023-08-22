import java.io.*;
import java.util.*;

public class _2072 {
    static int[][] Board = new int[19][19];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int turn = 1;
        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken())-1;
            Board[r][c] = turn;
            if(isConnectedFive(r,c)){
                System.out.println(i);
                return;
            }
            turn *= -1;
        }
        System.out.println(-1);
    }

    private static boolean isConnectedFive(int r, int c){
        int value = Board[r][c];

        int U = 0;
        for(int i=1; r-i>=0 && Board[r-i][c]==value; i++, U++);

        int D = 0;
        for(int i=1; r+i<19 && Board[r+i][c]==value; i++, D++);

        int L = 0;
        for(int i=1; c-i>=0 && Board[r][c-i]==value; i++, L++);

        int R = 0;
        for(int i=1; c+i<19 && Board[r][c+i]==value; i++, R++);

        int UL = 0;
        for(int i=1; r-i>=0 && c-i>=0 && Board[r-i][c-i]==value; i++, UL++);

        int UR = 0;
        for(int i=1; r-i>=0 && c+i<19 && Board[r-i][c+i]==value; i++, UR++);

        int DL = 0;
        for(int i=1; r+i<19 && c-i>=0 && Board[r+i][c-i]==value; i++, DL++);

        int DR = 0;
        for(int i=1; r+i<19 && c+i<19 && Board[r+i][c+i]==value; i++, DR++);

        return U+D==4 || L+R==4 || UL+DR==4 || UR+DL==4;
    }
}
