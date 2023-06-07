import java.io.*;
import java.util.*;

public class _28113 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        System.out.println( B<N ? "Subway" : A==B ? "Anything" : A<B ? "Bus" : "Subway");
    }
}
