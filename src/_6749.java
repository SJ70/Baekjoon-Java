import java.io.*;

public class _6749 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int max = Math.max(a,b);
        int min = Math.min(a,b);
        System.out.println( max+(max-min) );
    }
}
