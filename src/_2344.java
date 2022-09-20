import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2344 {
    public static void main(String[] args) throws IOException{
        Init();
        for(int r=0; r<R; r++){
            Light(r,0,0);
        }
        for(int c=0; c<C; c++){
            Light(R-1,c,3);
        }
        for(int r=R-1; r>=0; r--){
            Light(r,C-1,2);
        }
        for(int c=C-1; c>=0; c--){
            Light(0,c,1);
        }
        System.out.println(sb);
    }
    static int R,C;
    static boolean[][] Mirror;
    public static void Init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        Mirror = new boolean[R][C];
        for(int r=0; r<R; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<C; c++){
                Mirror[r][c] = Integer.parseInt(st.nextToken()) == 1;
            }
        }
    }
    static int[] Dr = {0,1,0,-1};
    static int[] Dc = {1,0,-1,0}; // 우,하,좌,상
    static StringBuilder sb = new StringBuilder();
    public static void Light(int r, int c, int dir){
        //System.out.printf("%d,%d(%d)\n",r,c,dir);
        if(r<0 || r>=R || c<0 || c>=C){
            sb.append(GetResult(r,c,dir)+" ");
            //System.out.println(GetResult(r,c,dir));
            return;
        }
        if(Mirror[r][c]) dir = Refract(dir);
        Light(r+Dr[dir],c+Dc[dir],dir);
    }
    public static int GetResult(int r, int c, int dir){
        if(dir==2) return r+1;
        if(dir==1) return R+c+1;
        if(dir==0) return R+C+(R-r);
        else return R+C+R+(C-c);
    }
    public static int Refract(int dir){
        return Math.abs(3-dir);
//        if(dir==0) return 3;
//        if(dir==1) return 2;
//        if(dir==2) return 1;
//        if(dir==3) return 0;
    }
}
