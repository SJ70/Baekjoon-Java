import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _25372 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            String str = br.readLine();
            int n = str.length();
            if(n>=6 && n<=9) sb.append("yes\n");
            else sb.append("no\n");
        }
        System.out.println(sb);
    }
}