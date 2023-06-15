import java.io.*;
import java.util.StringTokenizer;

public class _5717 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
            if(cnt==0) break;
            else sb.append(cnt).append('\n');
        }
        System.out.print(sb);
    }
}
