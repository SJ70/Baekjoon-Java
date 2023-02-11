import java.io.*;
import java.math.*;
public class _27433{
    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        BigInteger BI = new BigInteger("1");
        for(int i=1; i<=N; i++){
            BI = BI.multiply(new BigInteger(String.valueOf(i)));
        }
        System.out.println(BI);
    }
}