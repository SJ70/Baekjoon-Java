import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1531 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N,M;
    static int[][] Picture = new int[100][100];
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken())+1;
        for(int i=0; i<N; i++){
            Blind(new StringTokenizer(br.readLine()));
        }
        System.out.println(Covered);
    }
    static int Covered = 0;
    public static void Blind(StringTokenizer st){
        int r1 = Integer.parseInt(st.nextToken())-1;
        int c1 = Integer.parseInt(st.nextToken())-1;
        int r2 = Integer.parseInt(st.nextToken())-1;
        int c2 = Integer.parseInt(st.nextToken())-1;
        for(int r=r1; r<=r2; r++){
            for(int c=c1; c<=c2; c++){
                if(Picture[r][c]<M){
                    Picture[r][c]++;
                    if(Picture[r][c]==M){
                        Covered++;
                    }
                }
            }
        }
    }
}
