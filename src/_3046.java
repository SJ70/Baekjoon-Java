import java.io.*;
import java.util.*;

public class _3046 {
    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
        int R1 = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        System.out.println( 2*S - R1 );
    }
}
