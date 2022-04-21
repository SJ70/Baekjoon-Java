import java.io.*;
import java.util.Scanner;

public class _2446 {
    public static void main(String[] args) throws IOException {
        int N = new Scanner(System.in).nextInt();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=1; i<=N+N-1; i++){
            int tmp = i;
            if(tmp>N) tmp = 2*N-i;
            for(int j=1; j<tmp; j++)
                bw.write(' ');
            for(int j=0; j<=2*(N-tmp); j++)
                bw.write('*');
            bw.write('\n');
        }
        bw.flush();
    }
}