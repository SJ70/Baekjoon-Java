import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class _10996 {
    public static void main(String[] args) throws IOException {
        int N = new Scanner(System.in).nextInt();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0; i<N*2; i++){
            for(int j=0; j<N; j++)
                bw.write(( i%2==j%2 )?"*":" ");
            bw.write("\n");
        }
        bw.flush();
    }
}
