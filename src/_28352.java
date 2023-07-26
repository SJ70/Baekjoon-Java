import java.io.*;

public class _28352 {
    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        long result = 6L;
        for(int i=11; i<=N; i++){
            result *= i;
        }
        System.out.println(result);
    }
}
