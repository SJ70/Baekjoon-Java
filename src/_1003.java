import java.io.*;

public class _1003 {
    public static void main(String[] args) throws IOException {
        int[] F = new int[41];
        F[0]=0; F[1]=1;
        for(int i=2; i<=40; i++){
            F[i]=F[i-1]+F[i-2];
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        int one, zero;
        for(int i=0; i<T; i++){
            int n = Integer.parseInt(br.readLine());
            if(n==0) zero=1;
            else zero=F[n-1];
            one=F[n];
            bw.write(zero+" "+one+"\n");
        }
        bw.flush();
        bw.close();
    }
}
