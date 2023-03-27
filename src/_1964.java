import java.io.*;

public class _1964 {
    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        long result = 5L;
        for(long i=2; i<=N; i++){
            result += 3*i + 1;
            result %= 45678;
        }
        System.out.println(result);
    }
}
