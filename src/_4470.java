import java.io.*;

public class _4470 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            sb.append(i+1).append(". ").append(br.readLine()).append('\n');
        }
        System.out.print(sb);
    }
}
