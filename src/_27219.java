import java.io.*;

public class _27219 {
    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        StringBuilder sb = new StringBuilder();
        for(; N>=5; N-=5){
            sb.append('V');
        }
        for(; N>0; N--){
            sb.append('I');
        }
        System.out.print(sb);
    }
}
