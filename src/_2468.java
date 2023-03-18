import java.io.*;
import java.util.*;

public class _2468 {
    public static void main(String[] args) throws IOException{
        init();
        for(int d=minDepth; d<maxDepth; d++){
            maxSection = Math.max(maxSection, getSectionCnt(d));
        }
        System.out.println(maxSection);
    }
    static int N;
    static int minDepth = Integer.MAX_VALUE;
    static int maxDepth = Integer.MIN_VALUE;
    static int maxSection = 1;
    static int[][] D;
    public static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        D = new int[N][N];
        for(int r=0; r<N; r++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                int depth = Integer.parseInt(st.nextToken());
                minDepth = Math.min(minDepth, depth);
                maxDepth = Math.max(maxDepth, depth);
                D[r][c] = depth;
            }
        }
    }
    public static int getSectionCnt(int depth){
        int[][] section = new int[N][N];
        int i=0;
        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                if(section[r][c]==0 && D[r][c]>depth){
                    i++;
                    setSection(section, r, c, i, depth);
                }
            }
        }
        return i;
    }
    public static void setSection(int[][] s, int r, int c, int n, int depth){
        if(r>=0 && r<N && c>=0 && c<N && D[r][c]>depth && s[r][c]==0){
            s[r][c] = n;
            setSection(s,r+1,c,n,depth);
            setSection(s,r-1,c,n,depth);
            setSection(s,r,c+1,n,depth);
            setSection(s,r,c-1,n,depth);
        }
    }
}
