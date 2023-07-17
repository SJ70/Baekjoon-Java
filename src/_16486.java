import java.io.*;

public class _16486 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        int r = Integer.parseInt(br.readLine());
        System.out.println( length*2 + r*2*3.141592 );

    }
}
