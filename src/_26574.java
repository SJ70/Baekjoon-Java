import java.io.*;

public class _26574 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            int k = Integer.parseInt(br.readLine());
            sb.append(k).append(' ').append(k).append('\n');
        }
        System.out.print(sb);
    }
}
