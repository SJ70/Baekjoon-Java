import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class _2448 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static boolean[][] Blank;
    public static void main(String[] args) throws IOException {
        N = new Scanner(System.in).nextInt();
        Blank = new boolean[N][2*N];
        Erase(N);
        Print();
        bw.flush();
        bw.close();
    }
    public static void Erase(int n){
        for(int R=0; R<N; R+=n){
            for(int C=0; C<2*N; C+=n*2){
                //System.out.println(R+","+C);
                for(int r=0; r<n; r++){
                    for(int c=r*2+1; c<2*n; c++){
                        if(n==1 && (R+r)%3==2) continue;
                        Blank[R+r][C+c]=true;
                    }
                }
            }
        }
        if(n>1) Erase(n/2);
    }
    public static void Print() throws IOException {
        for(int r=0; r<N; r++){
            for(int i=0; i<N-1-r; i++)
                bw.write(" ");
            for(int c=0; c<r*2+1; c++)
                bw.write(Blank[r][c]?" ":"*");
            for(int i=0; i<N-1-r; i++)
                bw.write(" ");
            bw.write('\n');
        }
    }
}
