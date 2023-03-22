import java.io.*;
import java.util.*;

public class _1225 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String A = st.nextToken();
        String B = st.nextToken();

        long result = 0;
        for(int i=0; i<A.length(); i++){
            long a = A.charAt(i)-'0';
            for(int j=0; j<B.length(); j++){
                long b = B.charAt(j)-'0';
                result += a*b;
            }
        }
        System.out.println(result);
    }
}
