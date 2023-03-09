import java.io.*;

public class _5554 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = 0;
        for(int i=0; i<4; i++){
            N += Integer.parseInt(br.readLine());
        }
        System.out.printf("%d\n%d",N/60,N%60);
    }
}
