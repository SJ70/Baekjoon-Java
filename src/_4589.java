import java.util.*;
import java.io.*;

public class _4589 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder().append("Gnomes:\n");
        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            sb.append((A<=B == B<=C) ? "Ordered\n" : "Unordered\n");
        }
        System.out.print(sb);
    }
}
