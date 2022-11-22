import java.io.*;

public class _26005 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if(N==1) System.out.println(0);
        else System.out.println((N*N+1)/2);
    }
}
