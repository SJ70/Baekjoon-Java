import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _4920 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        for(int i=1; (N=Integer.parseInt(br.readLine().trim()))!=0; i++){
            Init();
            GetMax();
            sb.append(i+". "+Max+"\n");
        }
        System.out.println(sb);
    }
    static int N,Max;
    static int[][] Map;
    public static void Init() throws IOException{
        Max = -4000000;
        Map = new int[N][N];
        for(int r=0; r<N; r++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                Map[r][c] = Integer.parseInt(st.nextToken().trim());
            }
        }
    }
    public static void GetMax(){
        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                if(c+1<N){
                    int v2 = Map[r][c]+Map[r][c+1];
                    if(c+2<N){
                        int v3 = v2+Map[r][c+2];
                        if(c+3<N){
                            Max = Math.max(Max, v3+Map[r][c+3]);
                        }
                        if(r-1>=0){
//                            int tmp = Math.max(Math.max(Map[r-1][c],Map[r-1][c+1]),Map[r-1][c+2]);
                            Max = Math.max(Max, v3 + Math.max(Map[r-1][c],Map[r-1][c+1]) );
                        }
                        if(r+1<N){
//                            int tmp = Math.max(Math.max(Map[r+1][c],Map[r+1][c+1]),Map[r+1][c+2]);
                            Max = Math.max(Max, v3 + Math.max(Map[r+1][c+1],Map[r+1][c+2]) );
                        }
                    }
                    if(r+1<N){
                        int curve = v2+Map[r+1][c];
                        if(r-1>=0){
                            Max = Math.max(Max, curve+Map[r-1][c+1]);
                        }
//                        if(c-1>=0){
//                            Max = Math.max(Max, curve+Map[r+1][c-1]);
//                        }
                        Max = Math.max(Max, curve+Map[r+1][c+1]); //정사각형
                    }
                    if(r-1>=0){
                        int curve = v2+Map[r-1][c];
//                        if(r+1<N){
//                            Max = Math.max(Max, curve+Map[r+1][c+1]);
//                        }
                        if(c-1>=0){
                            Max = Math.max(Max, curve+Map[r-1][c-1]);
                        }
                    }
                }
                if(r+1<N){
                    int h2 = Map[r][c]+Map[r+1][c];
                    if(r+2<N){
                        int h3 = h2+Map[r+2][c];
                        if(r+3<N){
                            Max = Math.max(Max, h3+Map[r+3][c]);
                        }
                        if(c-1>=0){
//                            int tmp = Math.max(Math.max(Map[r][c-1],Map[r+1][c-1]),Map[r+2][c-1]);
                            Max = Math.max(Max, h3 + Math.max(Map[r+1][c-1],Map[r+2][c-1]) );
                        }
                        if(c+1<N){
//                            int tmp = Math.max(Math.max(Map[r][c+1],Map[r+1][c+1]),Map[r+2][c+1]);
                            Max = Math.max(Max, h3 + Math.max(Map[r][c+1],Map[r+1][c+1]) );
                        }
                    }
                }
            }
        }
    }
}
