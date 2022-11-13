import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _25965 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static long[][] MissionKDA;
    static int N, K,D,A;
    public static void main(String[] args) throws IOException{
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            init();
            sb.append(getResult()).append('\n');
        }
        System.out.print(sb);
    }
    public static void init() throws IOException{
        N = Integer.parseInt(br.readLine());
        MissionKDA = new long[N][3];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            MissionKDA[i][0] = Long.parseLong(st.nextToken());
            MissionKDA[i][1] = Long.parseLong(st.nextToken());
            MissionKDA[i][2] = Long.parseLong(st.nextToken());
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
    }
    public static long getResult(){
        long result = 0;
        for(int i=0; i<N; i++){
            long tmp = MissionKDA[i][0]*(long)K - MissionKDA[i][1]*(long)D + MissionKDA[i][2]*(long)A;
            if(tmp>0) result+=tmp;
        }
        return result;
    }
}
