import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class _2440 {
    public static void main(String[] args) throws IOException {
        int N = new Scanner(System.in).nextInt();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=N; i>0; i--){
            for(int j=0; j<i; j++){
                bw.write('*');
            }
            bw.write('\n');
        }
        bw.flush();
    }
}
