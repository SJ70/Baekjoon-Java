import java.io.*;
import java.util.Scanner;

public class _2522 {
    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = new Scanner(System.in).nextInt();
        for(int i=-N+1; i<=N-1; i++){
            int tmp = Math.abs(i);
            for(int j=0; j<tmp; j++)
                bw.write(" ");
            for(int j=0; j<N-tmp; j++)
                bw.write("*");
            bw.write("\n");
        }
        bw.flush();
    }
}
