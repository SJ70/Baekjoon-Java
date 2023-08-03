import java.io.*;

public class _5524 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            sb.append(br.readLine().toLowerCase()).append('\n');
        }
        System.out.print(sb);
    }
}
