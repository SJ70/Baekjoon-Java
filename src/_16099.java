import java.io.*;
import java.util.*;

public class _16099 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken()) * Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken()) * Long.parseLong(st.nextToken());
            sb.append(a==b ? "Tie" : (a>b ? "TelecomParisTech" : "Eurecom")).append('\n');
        }
        System.out.print(sb);
    }
}
