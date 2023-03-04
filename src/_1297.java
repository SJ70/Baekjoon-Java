import java.io.*;
import java.util.*;

public class _1297 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int D = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        double per = D / Math.sqrt(H*H + W*W);
        System.out.printf("%d %d",(int)Math.floor(H*per),(int)Math.floor(W*per));
    }
}
