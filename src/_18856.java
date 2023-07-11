import java.io.*;

public class _18856 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        sb.append(N).append('\n');
        for(int i=1; i<N; i++){
            sb.append(i).append(' ');
        }
        sb.append(53);
        System.out.println(sb);
    }
}
