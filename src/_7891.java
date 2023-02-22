import java.io.*;
import java.util.*;

public class _7891{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            sb.append( Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()) ).append('\n');
        }
        System.out.print(sb);
    }
}