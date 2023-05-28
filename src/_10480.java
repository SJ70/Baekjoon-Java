import java.io.*;

public class _10480 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            int N = Integer.parseInt(br.readLine());
            sb.append(N).append(" is ").append(Math.abs(N)%2==1?"odd":"even").append('\n');
        }
        System.out.print(sb);
    }
}
