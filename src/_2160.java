import java.io.*;

public class _2160 {
    public static void main(String[] args) throws IOException{
        Input();
        Compare();
        System.out.printf("%d %d",p1+1,p2+1);
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static boolean[][][] Pic;
    public static void Input() throws IOException{
        N = Integer.parseInt(br.readLine());
        Pic = new boolean[N][5][7];
        for(int i=0; i<N; i++){
            for(int r=0; r<5; r++){
                String str = br.readLine();
                for(int c=0; c<7; c++){
                    Pic[i][r][c] = ( str.charAt(c)=='X' );
                }
            }
        }
    }
    static int Min_Diff = 36;
    static int p1, p2;
    public static void Compare(){
        for(int i=0; i<N-1; i++){
            for(int j=i+1; j<N; j++){
                int Diff = 0;
                for(int r=0; r<5; r++){
                    for(int c=0; c<7; c++){
                        if( Pic[i][r][c] != Pic[j][r][c] ){
                            Diff++;
                        }
                        if(Diff>Min_Diff) break;
                    }
                    if(Diff>Min_Diff) break;
                }
                if( Diff < Min_Diff ){
                    Min_Diff = Diff;
                    p1 = i;
                    p2 = j;
                }
            }
        }
    }
}
