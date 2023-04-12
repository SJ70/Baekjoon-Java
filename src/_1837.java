import java.io.*;
import java.math.*;
import java.util.*;

public class _1837 {
    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
        BigInteger P = new BigInteger(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        for(int i=2; i<K; i++){
            if(P.remainder(new BigInteger(Integer.toString(i))).equals(new BigInteger("0"))){
                System.out.printf("BAD %d\n",i);
                return;
            }
        }
        System.out.println("GOOD");
    }
}
