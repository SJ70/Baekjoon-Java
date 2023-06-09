import java.io.*;
import java.util.StringTokenizer;

public class _20499 {
    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine(), "/");
        int K = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());

        if(K+A<D || D==0) System.out.println("hasu");
        else System.out.println("gosu");
    }
}
