import java.io.*;

public class _10026 {
    public static void main(String[] args) throws IOException{
        Init();
        Solve(Map);
        Solve(Map2);
    }
    static int N;
    static char[][] Map,Map2;
    public static void Init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Map = new char[N][N];
        Map2 = new char[N][N];
        for(int r=0; r<N; r++){
            String str = br.readLine();
            for(int c=0; c<N; c++){
                Map[r][c] = str.charAt(c);
                Map2[r][c] = str.charAt(c)=='B'?'B':'.';
            }
        }
    }
    static int[][] section;
    static int sNo;
    public static void Solve(char[][] M){
        section = new int[N][N];
        sNo = 0;
        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                if(section[r][c]!=0) continue;
                sNo++;
                visit(M,r,c,M[r][c]);
            }
        }
        System.out.print(sNo+" ");
    }
    public static void visit(char[][] M, int r, int c, char color){
        if( r<0 || r>=N || c<0 || c>=N || section[r][c]!=0 || M[r][c]!=color ) return;
        section[r][c]=sNo;
        visit(M,r-1,c,color);
        visit(M,r+1,c,color);
        visit(M,r,c-1,color);
        visit(M,r,c+1,color);
    }
}
