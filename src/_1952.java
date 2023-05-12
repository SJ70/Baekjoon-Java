import java.io.*;
import java.util.*;

public class _1952 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        if(M<=N) System.out.println(M*2-2);
        else System.out.println(N*2-1);
    }
}