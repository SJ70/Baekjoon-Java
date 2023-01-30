import java.io.*;

public class _23810 {
    static int N;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args ) throws IOException{
        N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        Long();
        Short();
        Long();
        Short();
        Short();
        System.out.print(sb);
    }
    public static void Long(){
        for(int r=0; r<N; r++){
            for(int c=0; c<N*5; c++){
                sb.append('@');
            }
            sb.append('\n');
        }
    }
    public static void Short(){
        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                sb.append('@');
            }
            sb.append('\n');
        }
    }
}
