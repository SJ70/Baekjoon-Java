import java.io.*;

public class _4999 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = br.readLine().length();
        int b = br.readLine().length();
        System.out.println( a>=b ? "go" : "no");
    }
}