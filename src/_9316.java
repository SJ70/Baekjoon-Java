import java.io.*;

public class _9316 {
    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++){
            sb.append("Hello World, Judge ").append(i).append('!');
            if(i==N) break;
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
