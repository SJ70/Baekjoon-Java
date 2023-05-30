import java.io.*;

public class _1834 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long result = 0;
        for(long i=1; i<N; i++){
            result += N*i + i;
        }
        System.out.println(result);
    }
}
