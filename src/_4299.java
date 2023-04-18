import java.io.*;
import java.util.*;

public class _4299 {
    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
        int sum = Integer.parseInt(st.nextToken());
        int sub = Integer.parseInt(st.nextToken());
        if(sum%2 != sub%2 || sum < sub) System.out.println(-1);
        else System.out.printf("%d %d",(sum+sub)/2,(sum-sub)/2);
    }
}
