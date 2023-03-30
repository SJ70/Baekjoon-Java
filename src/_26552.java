import java.io.*;

public class _26552 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            int N = Integer.parseInt(br.readLine());
            N++;
            for(int d=(int)Math.pow(10,(int)Math.log10(N)); d>0; d/=10){
                int value = N/d;
                N %= d;
                sb.append(value==0?1:value);
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }
}
