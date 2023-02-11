import java.io.*;
import java.util.*;

public class _7562 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws IOException {
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            sb.append(getResult()).append('\n');
        }
        System.out.print(sb);
    }
    static int[] dir_r = new int[] {1,1,-1,-1,2,2,-2,-2};
    static int[] dir_c = new int[] {2,-2,2,-2,1,-1,1,-1};
    public static int getResult() throws IOException{
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int fromR = Integer.parseInt(st.nextToken());
        int fromC = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int toR = Integer.parseInt(st.nextToken());
        int toC = Integer.parseInt(st.nextToken());

        Queue<int[]> q = new ArrayDeque<>();
        HashSet<Integer> hs = new HashSet<>();
        q.add(new int[]{fromR,fromC,0});
        while(!q.isEmpty()){
            int r = q.peek()[0];
            int c = q.peek()[1];
            int cnt = q.poll()[2];
            if(r==toR && c==toC) return cnt;

            for(int i=0; i<8; i++){
                int nextR = r+dir_r[i];
                int nextC = c+dir_c[i];
                int hashCode = nextR*1000 + nextC;
                if(nextR<0 || nextR>=N || nextC<0 || nextC>=N || hs.contains(hashCode)) continue;
                hs.add(hashCode);
                q.add(new int[]{nextR,nextC,cnt+1});
            }
        }
        return -1;
    }
}
