import java.io.*;
import java.util.*;

public class _11653 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = new Scanner(System.in).nextInt();
        for(int i=2; i<=N; i++){
            while(N%i==0){
                N/=i;
                bw.write(i+"\n");
            }
            if(N==1) break;
        }
        bw.flush();
        bw.close();
    }
}