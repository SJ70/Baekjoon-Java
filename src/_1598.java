import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1598 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken()) -1;
        int B = Integer.parseInt(st.nextToken()) -1;
        System.out.println( Math.abs(A/4-B/4) + Math.abs(A%4-B%4) );
    }
}
