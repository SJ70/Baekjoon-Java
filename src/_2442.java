import java.io.*;
import java.util.Scanner;

public class _2442 {
    public static void main(String[] args) throws IOException {
        int N = new Scanner(System.in).nextInt();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=1; i<=N; i++){
            for(int j=N-i; j>0; j--)
                bw.write(' ');
            for(int j=1; j<=i-1; j++)
                bw.write('*');
            for(int j=0; j<i; j++)
                bw.write('*');
            bw.write('\n');
        }
        bw.flush();
    }
}