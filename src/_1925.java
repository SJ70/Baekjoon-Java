import java.io.*;
import java.util.*;

public class _1925 {
    static int[] dist = new int[3];
    public static void main(String[] args) throws IOException{
        init();
        System.out.println(solve());
    }
    public static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] spot = new int[3][2];
        for(int i=0; i<3; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            spot[i][0] = Integer.parseInt(st.nextToken());
            spot[i][1] = Integer.parseInt(st.nextToken());
        }
        int k = 0;
        for(int i=0; i<2; i++){
            for(int j=i+1; j<3; j++){
                dist[k++] = getDistPow(spot[i][0], spot[i][1], spot[j][0], spot[j][1]);
            }
        }
        Arrays.sort(dist);
    }
    public static int getDistPow(int r1, int c1, int r2, int c2){
        return (int)Math.pow(r1-r2,2) + (int)Math.pow(c1-c2,2);
    }
    public static String solve(){
        int L = dist[2];
        int M = dist[1];
        int S = dist[0];

        if(Math.sqrt(S)+Math.sqrt(M)==Math.sqrt(L)) return "X";
        if(L==S) return "JungTriangle";
        if(L==M) return "Yeahkak2Triangle";
        if(S==M){
            if(S+M==L) return "Jikkak2Triangle";
            else return "Dunkak2Triangle";
        }
        if(S+M<L) return "DunkakTriangle";
        else if(S+M==L) return "JikkakTriangle";
        else return "YeahkakTriangle";
    }
}
