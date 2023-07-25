import java.io.*;
import java.util.*;

public class _1270 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            sb.append(getResult(new StringTokenizer(br.readLine()))).append('\n');
        }
        System.out.print(sb);
    }

    private static String getResult(StringTokenizer st){
        HashMap<Long, Long> HS = new HashMap<>();
        int N = Integer.parseInt(st.nextToken());
        int HALF = N/2;
        for(int i=0; i<N; i++){
            long team = Long.parseLong(st.nextToken());
            HS.put(team, HS.getOrDefault(team,0L)+1);
            if(HS.get(team) > HALF){
                return String.valueOf(team);
            }
        }
        return "SYJKGW";
    }
}
