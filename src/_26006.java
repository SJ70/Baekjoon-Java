import java.io.*;
import java.util.*;

public class _26006 {
    static boolean[][] D = new boolean[3][3];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int KingR = Integer.parseInt(st.nextToken());
        if(KingR==1) D[0][0]=D[0][1]=D[0][2]=true;
        else if(KingR==N) D[2][0]=D[2][1]=D[2][2]=true;
        int KingC = Integer.parseInt(st.nextToken());
        if(KingC==1) D[0][0]=D[1][0]=D[2][0]=true;
        else if(KingC==N) D[0][2]=D[1][2]=D[2][2]=true;

        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int QueenR = Integer.parseInt(st.nextToken());
            int QueenC = Integer.parseInt(st.nextToken());
            for(int r=0; r<3; r++){
                for(int c=0; c<3; c++){
                    if(D[r][c]) continue;
                    int R = KingR-1+r;
                    int C = KingC-1+c;
                    D[r][c] = (R==QueenR || C==QueenC || (R-C)==(QueenR-QueenC) || (N-R-C)==(N-QueenR-QueenC));
                }
            }
        }

        int cnt = 0;
        for(int r=0; r<3; r++){
            for(int c=0; c<3; c++){
                if(D[r][c]) cnt++;
            }
        }
        System.out.println(D[1][1]?(cnt==9?"CHECKMATE":"CHECK"):(cnt==8?"STALEMATE":"NONE"));
    }
}
