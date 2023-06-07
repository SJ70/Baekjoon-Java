import java.io.*;

public class _5300 {
    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++){
            sb.append(i);
            if(i%6==0 || i==N) sb.append(" Go!");
            if(i<N) sb.append(' ');
        }
        System.out.print(sb);
    }
}
