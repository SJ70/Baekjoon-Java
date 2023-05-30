import java.io.*;

public class _7595 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N;
        while((N=Integer.parseInt(br.readLine()))!=0){
            for(int i=1; i<=N; i++){
                for(int j=1; j<=i; j++){
                    sb.append('*');
                }
                sb.append('\n');
            }
        }
        System.out.print(sb);
    }
}
