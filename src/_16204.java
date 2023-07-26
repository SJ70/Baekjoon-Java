import java.io.*;
import java.util.*;

public class _16204 {
    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int writtenO = M;
        int writtenX = N-M;
        int writeO = K;
        int writeX = N-K;

        System.out.println( Math.min(writtenO, writeO) + Math.min(writtenX, writeX) );
    }
}
