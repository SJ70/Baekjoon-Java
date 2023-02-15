import java.util.*;
import java.io.*;

public class _5086{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a==0 && b==0) break;
            if(a>b && a%b==0) sb.append("multiple\n");
            else if(b>a && b%a==0) sb.append("factor\n");
            else sb.append("neither\n");
        }
        System.out.print(sb);
    }
}