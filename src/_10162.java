import java.io.*;

public class _10162 {
    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        if(N%10>0){
            System.out.println(-1);
            return;
        }
        int A = N/300;
        N%=300;
        int B = N/60;
        N%=60;
        int C = N/10;
        System.out.printf("%d %d %d",A,B,C);
    }
}
