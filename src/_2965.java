import java.io.*;
import java.util.*;

public class _2965 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int d1 = b-a;
        int d2 = c-b;

        System.out.println(Math.max(d1,d2)-1);
    }
}
