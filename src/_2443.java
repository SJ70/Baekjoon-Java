import java.io.*;
import java.util.Scanner;

public class _2443 {
    public static void main(String[] args) throws IOException {
        int N = new Scanner(System.in).nextInt();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0; i<N; i++){
            for(int j=0; j<i; j++)
                bw.write(' ');
            for(int j=N+N-1-i-i; j>0; j--)
                bw.write('*');
            bw.write('\n');
        }
        bw.flush();
    }
}